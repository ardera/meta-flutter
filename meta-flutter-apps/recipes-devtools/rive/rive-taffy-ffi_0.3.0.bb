#
# Copyright (c) 2024 Joel Winarske. All rights reserved.
#

SUMMARY = "Rive Common"
HOMEPAGE = "https://pub.dev/packages/rive_common"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

S = "${WORKDIR}/git"

CARGO_SRC_DIR = "taffy_ffi"

inherit cargo

SRC_URI += " \
    git://github.com/meta-flutter/rive-common.git;protocol=https;lfs=0;nobranch=1;name=taffy_ffi \
    git://github.com/DioxusLabs/taffy;lfs=0;nobranch=1;protocol=https;destsuffix=taffy;name=taffy \
    crate://crates.io/arrayvec/0.7.4 \
    crate://crates.io/autocfg/1.1.0 \
    crate://crates.io/grid/0.11.0 \
    crate://crates.io/num-traits/0.2.18 \
    crate://crates.io/slotmap/1.0.7 \
    crate://crates.io/version_check/0.9.4 \
"

SRCREV_FORMAT .= "_taffy_ffi"
SRCREV_taffy_ffi = "2141e28c8ed7fb2e5edd8cdc41bd6332ff553721"
SRCREV_FORMAT .= "_taffy"
SRCREV_taffy = "daa07e0f4e3e009f5b0c11ada5df9785efd4b2c2"

EXTRA_OECARGO_PATHS += "${WORKDIR}/taffy"

RUSTFLAGS += " -Clink-arg=-Wl,-soname=taffy_ffi.so.${PV}"

cargo_do_install:append() {
    cd ${D}${libdir}/rustlib/aarch64-agl-linux-gnu/lib
    mv libtaffy_ffi.so libtaffy_ffi.so.0.3.0
    ln -sf libtaffy_ffi.so.0.3.0 libtaffy_ffi.so
}

FILES:${PN}-dev = "${libdir}"
