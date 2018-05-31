SUMMARY = "Google Web Tool"
HOMEPAGE = "http://www.gwtproject.org/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=986f6fcbfc47ef0b18ef98427108fcc3"

DEPENDS = "jamvm-native"

SRC_URI = "https://storage.googleapis.com/gwt-releases/gwt-${PV}.zip"
SRC_URI[md5sum] = "c295406d68c5ef364e445068599aa6d4"

S = "${WORKDIR}/gwt-${PV}"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

BBCLASSEXTEND = "native nativesdk"
