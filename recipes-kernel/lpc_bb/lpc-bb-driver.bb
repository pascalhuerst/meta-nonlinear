SUMMARY = "Nonlinear-Labs lpc-bb kernel module"
HOMEPAGE = "https://github.com/nonlinear-labs-dev/lpc_bb"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit module

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

SRC_URI = "git://github.com/nonlinear-labs-dev/lpc_bb.git;branch=master"

RPROVIDES_${PN} += "kernel-module-lpc_bb_driver"

FILES_${PN} = "${libdir}"
