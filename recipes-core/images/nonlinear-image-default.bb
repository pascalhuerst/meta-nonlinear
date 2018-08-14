SUMMARY = "Default nonlinear deploy image"

IMAGE_INSTALL = "\
	kernel-modules \
	initramfs-live-boot \
	initramfs-live-install \
	initramfs-live-install-efi \
	${ROOTFS_BOOTSTRAP_INSTALL} \
	packagegroup-core-boot \
	${CORE_IMAGE_EXTRA_INSTALL} \
	alsa-utils \
	valgrind gdb \
	systemd-analyze \
	strace \
	jack-server jack-utils \
	nonlinear-nlaudio \
	"

IMAGE_LINGUAS = " "

#usr_merge() {
#  for d in lib bin sbin; do
#    cp -a ${IMAGE_ROOTFS}/$d/* ${IMAGE_ROOTFS}/usr/$d/
#    rm -rf ${IMAGE_ROOTFS}/$d
#    ln -s usr/$d ${IMAGE_ROOTFS}/$d
#  done
#}
#IMAGE_PREPROCESS_COMMAND += "usr_merge;"


LICENSE = "MIT"

inherit core-image

#IMAGE_ROOTFS_SIZE ?= "8192"
#IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"
