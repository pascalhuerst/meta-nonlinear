SUMMARY = "Update nonlinear deploy image"

IMAGE_FEATURES = "allow-empty-password empty-root-password"

INITRAMFS_SCRIPTS ?= "\
                      initramfs-framework-base \
                      initramfs-module-udev \
                     "

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
PACKAGE_INSTALL = "${IMAGE_INSTALL} ${INITRAMFS_SCRIPTS} ${VIRTUAL-RUNTIME_base-utils} udev base-passwd"

NONLINEAR_KMODS = " \
	lpc-bb-driver \
	espi-driver \
	"

IMAGE_INSTALL = "\
	${CORE_IMAGE_EXTRA_INSTALL} \
	packagegroup-core-boot \
	kernel-modules \
	nonlinear-rootfs-bbb \
	${NONLINEAR_KMODS} \
	nlimagemaker \
	"

IMAGE_LINGUAS = " "

export IMAGE_BASENAME = "${MLPREFIX}nonlinear-bbb-image-initramfs.bb"
IMAGE_LINGUAS = ""

LICENSE = "MIT"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"

inherit core-image
