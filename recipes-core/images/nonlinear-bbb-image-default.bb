SUMMARY = "Default nonlinear deploy image"

IMAGE_INSTALL = "\
	kernel-modules \
	valgrind gdb \
	systemd-analyze \
	strace \
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

MACHINE_EXTRA_RRECOMMENDS += "kernel-module-lpc_bb_driver kernel-module-epsi_driver"

LICENSE = "MIT"

inherit core-image

#IMAGE_ROOTFS_SIZE ?= "8192"
#IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"
