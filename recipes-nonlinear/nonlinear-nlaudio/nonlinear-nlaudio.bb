SUMMARY = "Nonlinear Labs nlaudio framework"
HOMEPAGE = "https://github.com/nonlinear-labs-dev/nlaudio"
BUGTRACKER = "https://github.com/nonlinear-labs-dev/nlaudio/issues"
SECTION = "libs"

DEPENDS = "alsa-lib jack"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.GPL2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://github.com/nonlinear-labs-dev/nlaudio.git;protocol=git"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"
PV = "master+git-${SRCPV}"

#RDEPENDS_${PN} = "alsa-lib jack"

inherit cmake

# I did not manage to use only variables here and I'm quite annoyed!
FILES_${PN} = "${libdir} ${bindir} /etc/systemd/system"
FILES_${PN}-dbg = "${libdir}/.debug /usr/src ${includedir}/nlaudio"
