SUMMARY = "Nonlinear Labs Playground"
HOMEPAGE = "http://www.nonlinear-labs.de"
BUGTRACKER = "https://github.com/nonlinear-labs-dev/C15/issues"
SECTION = "Applications/System"

DEPENDS = "util-linux glibmm libsoup-2.4 avahi dbus freetype boost gwt-native"

# For now, so i can test
LICENSE = "CLOSED"
#LIC_FILES_CHKSUM = "file://LICENSE.GPL2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://github.com/nonlinear-labs-dev/C15.git;protocol=git;branch=master"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"
PV = "${AUTOREV}"


inherit cmake


EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=Release -DJARSDIR=${TOPDIR}/tmp-glibc/work/x86_64-linux/gwt-native/2.8.2-r0/gwt-2.8.2"

do_install() {
	DESTDIR='${D}' cmake_runcmake_build --target playground
	DESTDIR='${D}' cmake_runcmake_build --target bbbb
	DESTDIR='${D}' cmake_runcmake_build --target NonMaps
}

FILES_${PN} = "/nonlinear/playground /etc/systemd/system"
