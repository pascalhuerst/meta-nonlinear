SUMMARY = "Update nonlinear deploy image"

IMAGE_FEATURES = "allow-empty-password empty-root-password"

INITRAMFS_SCRIPTS ?= "\
                      initramfs-framework-base \
                      initramfs-module-udev \
                     "

PACKAGE_INSTALL = "${INITRAMFS_SCRIPTS} ${VIRTUAL-RUNTIME_base-utils} udev base-passwd"

NONLINEAR_KMODS = " \
	lpc-bb-driver \
	espi-driver \
	"

IMAGE_INSTALL = "\
	${CORE_IMAGE_EXTRA_INSTALL} \
	packagegroup-core-boot \
	kernel-modules \
	nonlinear-rootfs \
	${NONLINEAR_KMODS} \
	nlimagemaker \
	mtd \
	"

IMAGE_LINGUAS = " "

export IMAGE_BASENAME = "${MLPREFIX}nonlinear-bbb-image-initramfs.bb"
IMAGE_LINGUAS = ""

LICENSE = "MIT"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"

inherit core-image
