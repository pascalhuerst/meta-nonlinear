DESCRIPTION = "Linux kernel for beagle bone black based nonlinear-labs platforms"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

SRC_URI = "git://github.com/nonlinear-labs-dev/linux.git;branch=${SRCBRANCH}"

KERNEL_DEVICETREE ?= "nonlinear-labs-2D.dtb"

KERNEL_IMAGETYPE = "uImage"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

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
