SUMMARY = "Nonlinear Labs nlimagemaker"
HOMEPAGE = "https://github.com/nonlinear-labs-dev/nlimagemaker"
BUGTRACKER = "https://github.com/nonlinear-labs-dev/nlimagemaker/issues"
SECTION = "libs"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "https://github.com/nonlinear-labs-dev/nlimagemaker.git;protocol=git"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"
PV = "master+git-${SRCPV}"

inherit cmake

FILES_${PN} = "${bindir}"
