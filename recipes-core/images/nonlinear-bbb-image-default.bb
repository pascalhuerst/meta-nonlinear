SUMMARY = "Default nonlinear deploy image"

IMAGE_FEATURES = "ssh-server-openssh allow-empty-password empty-root-password"

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
	dhcp-server \
	i2c-tools \
	kernel-modules \
	valgrind gdb \
	systemd-analyze \
	nonlinear-playground \
	nonlinear-rootfs \
	${NONLINEAR_KMODS} \
	linux-firmware-ralink \
	hostapd \
	"

update_config_files() {
  mv ${IMAGE_ROOTFS}/etc/ssh/sshd_config.nonlinear ${IMAGE_ROOTFS}/etc/ssh/sshd_config
  mv ${IMAGE_ROOTFS}/etc/hostapd.conf.nonlinear ${IMAGE_ROOTFS}/etc/hostapd.conf
}
IMAGE_PREPROCESS_COMMAND += "update_config_files;"


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
