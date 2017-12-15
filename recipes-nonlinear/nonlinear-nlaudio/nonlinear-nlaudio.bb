SUMMARY = "Nonlinear Labs nlaudio framework"
HOMEPAGE = "https://github.com/pascalhuerst/nlaudio"
BUGTRACKER = "https://github.com/pascalhuerst/nlaudio/issues"
SECTION = "libs"

DEPENDS = "alsa-lib jack"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.GPL2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://github.com/pascalhuerst/nlaudio.git;protocol=git"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"
PV = "master+git-${SRCPV}"

#RDEPENDS_${PN} = "alsa-lib jack"

inherit cmake

# I did not manage to use only variables here and I'm quite annoyed!
FILES_${PN} = "${libdir} ${bindir}"
FILES_${PN}-dbg = "${libdir}/.debug /usr/src ${includedir}/nlaudio"

#FILES_${PN} = "${bindir} ${libdir}/libnlaudio.*"
#FILES_${PN}-dev = "${libdir}/cmake ${incdir}/nlaudio"

