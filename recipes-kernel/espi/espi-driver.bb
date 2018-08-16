SUMMARY = "Nonlinear-Labs espi kernel module"
HOMEPAGE = "https://github.com/nonlinear-labs-dev/espi"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit module

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

SRC_URI = "git://github.com/nonlinear-labs-dev/espi.git;branch=master"

RPROVIDES_${PN} += "kernel-module-espi_driver"

KERNEL_MODULE_AUTOLOAD += "espi_driver"

FILES_${PN} = "${libdir}"
