#!/bin/bash -eu
export NDK="${HOME}/install/android_platform/android-ndk-r8"
export PATH="${NDK}:${PATH}"
ndk-build "$@"
