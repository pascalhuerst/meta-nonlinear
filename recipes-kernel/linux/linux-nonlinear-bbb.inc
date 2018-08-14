DESCRIPTION = "Linux kernel for beagle bone black based nonlinear-labs platforms"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

# Put a local version until we have a true SRCREV to point to
#LOCALVERSION ?= "+nepos"

SRC_URI = "git://github.com/nonlinear-labs-dev/linux.git;branch=${SRCBRANCH}"
SRCREV = "${AUTOREV}"
PV = "git-${SRCPV}"
S = "${WORKDIR}/git"

KERNEL_PRIORITY = "1000000000000"
KERNEL_DEFCONFIG_arm ?= "${S}/arch/arm/configs/nonlinear_defconfig"
#KERNEL_MODULE_AUTOLOAD += " espi_driver"
#KERNEL_MODULE_AUTOLOAD += " lpc_bbb_driver"

do_configure_prepend() {
  cp ${KERNEL_DEFCONFIG} ${B}/.config
}
