SUMMARY = "KDAB Cabin Demo Application"
DESCRIPTION = "KDAB Cabin Demo Application"
AUTHOR = "KDAB"
HOMEPAGE = "https://github.com/KDAB/cabin-demo"
SECTION = "graphics"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=97f6027151f4d03621a54f6fa41f950f"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/KDAB/cabin-demo.git;lfs=0;branch=main;protocol=https;destsuffix=git"

S = "${WORKDIR}/git"

PUBSPEC_APPNAME = "cabin_demo"
FLUTTER_APPLICATION_INSTALL_PREFIX = "/flutter"

inherit flutter-app
