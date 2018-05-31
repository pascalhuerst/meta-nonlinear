SUMMARY = "Nonlinear Labs Playground"
HOMEPAGE = "http://www.nonlinear-labs.de"
BUGTRACKER = "https://github.com/nonlinear-labs-dev/C15/issues"
SECTION = "Applications/System"

DEPENDS = "util-linux glibmm libsoup-2.4 avahi dbus freetype boost gwt-native"

# For now, so i can test
LICENSE = "CLOSED"
#LIC_FILES_CHKSUM = "file://LICENSE.GPL2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://github.com/nonlinear-labs-dev/C15.git;protocol=git"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"
PV = "master+git-${SRCPV}"

#RDEPENDS_${PN} = ""

EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=Release -DCMAKE_INSTALL_PREFIX=/nonlinear/playground -DJARSDIR=${GWT_COMPILER_DIR}"

inherit cmake

FILES_${PN} = "/nonlinear/playground"
FILES_${PN}-dbg = "${libdir}/.debug /usr/src ${includedir}/nlaudio"
