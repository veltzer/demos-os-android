#!/bin/sh
TOOLS="${HOME}/install/android_platform/android-sdk-linux-r16/platform-tools/"
export TOOLS
PATH="${TOOLS}:${PATH}"
export PATH
"${TOOLS}/adb" push hello.ko /data
