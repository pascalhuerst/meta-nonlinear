SUMMARY = "Default nonlinear deploy image"

NONLINEAR_KMODS = " \
	lpc-bb-driver \
	espi-driver \
	"

IMAGE_INSTALL = "\
	${CORE_IMAGE_EXTRA_INSTALL} \
	packagegroup-core-boot \
	wireless-tools iw \
	usbutils \
	evtest \
	strace lsof \
	iperf3 \
	dhcpd \
	i2c-tools \
	kernel-modules \
	valgrind gdb \
	systemd-analyze \
	nonlinear-rootfs \
	${NONLINEAR_KMODS} \
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
