# TOFIX

Findings from a code scan on 2026-10-04.

## Medium

- `c/hello-c/script.sh:3` - executes `"${ANDROID_NDK_ROOT}/build"`, which is a directory in the NDK, not a command, so the script always fails with "Is a directory"; the sibling scripts (`c/hello-jni/script.sh:4`) run `ndk-build` - do the same (and note this example builds with its own `Makefile`, so the script may simply be redundant).
- `README.md:6` - describes `android_build` as "the shared Gradle build setup", but it only holds `README.txt` and `key.gpg` (the 2009 AOSP DSA-1024 signing public key for verifying `repo`); there is no shared Gradle setup - each app under `apps/` has its own wrapper; fix the description.
- `apps/SaveRestoreState/gradle/wrapper/gradle-wrapper.properties:3` - all five Gradle apps use Gradle 7.0.2 with Android Gradle Plugin 7.0.4 (`apps/*/build.gradle`) and `compileSdk 32`; Gradle 7.0.x cannot run on a current JDK (17+/21), so none of the apps builds with a present-day Android Studio/JDK; upgrade the wrapper and AGP together (e.g. via the AGP Upgrade Assistant).

## Low

- `c/hello-c/Makefile:1` - the native examples hard-code NDK r7/r8 and SDK r16 paths under `/home/mark/install/...` (also `c/hello-calc/script.sh:2`, `c/hello-jni/script.sh:2`, `c/module/Makefile:2`, `c/module/copy_ko_to_target.sh:2`, `c/module/shell.sh:2`); the GCC toolchains they point to were removed from the NDK long ago; take the NDK/SDK location from `ANDROID_NDK_HOME`/`ANDROID_HOME` and use clang.
- `scripts/source_me.sh:3` - calls `path_add`, a function defined only in the author's personal shell setup, so sourcing it anywhere else fails with "command not found"; use plain `PATH="${HOME}/install/android-sdk-linux/platform-tools:${PATH}"`.
- `exercises/dynamic_buttons.md:10` - the reference titled "handling double click" links to `View.OnLongClickListener`, which handles long presses, not double clicks; fix the text or the link (e.g. `GestureDetector.OnDoubleTapListener`).
- `README.txt:1` - duplicates the intro of `README.md` (one line); delete it.
- `scripts/eclipse.sh:2` - Eclipse ADT launchers (also `apps/ManyExercisesTogether/scripts/eclipse_java.sh`) for a toolchain Google retired in 2015; `apps/ManyExercisesTogether` is an Eclipse/ant project with no Gradle build; remove or migrate them.
