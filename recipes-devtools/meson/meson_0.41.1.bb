HOMEPAGE = "http://mesonbuild.com"
SUMMARY = "A high performance build system"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = " \
    git://github.com/mesonbuild/meson.git \
"

SRCREV = "c5e7774e27c56f09c3a16458c6d9931e01cee100"

S = "${WORKDIR}/git"

inherit setuptools3

RDEPENDS_${PN}_class-target = "ninja python3-core python3-modules"

BBCLASSEXTEND = "native"
