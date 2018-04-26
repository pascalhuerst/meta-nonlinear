SUMMARY = "Google Web Tool"
HOMEPAGE = "http://www.gwtproject.org/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=986f6fcbfc47ef0b18ef98427108fcc3"

DEPENDS = "java-native"

SRC_URI = "https://storage.googleapis.com/gwt-releases/gwt-${PV}.zip"

S = "${WORKDIR}/gwt-${PV}"

do_configure[noexec] = "1"
do_compile[noexec] = "1"
do_install[noexec] = "1"

do_install() {
        unzip -u ${S}/gwt-${PV} gwt-${PV}/gwt-\*.jar -d ${D}${bindir}/gwt-${PV}
}

BBCLASSEXTEND = "native nativesdk"
