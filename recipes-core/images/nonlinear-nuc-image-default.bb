SUMMARY = "Default nonlinear NUC deploy image"

IMAGE_FEATURES = "allow-empty-password empty-root-password package-management ssh-server-openssh"

IMAGE_INSTALL = "\
	${CORE_IMAGE_EXTRA_INSTALL} \
	packagegrounp-core-boot \
	usbutils \
	kernel-modules \
	initramfs-live-install-efi \
	alsa-utils \
	valgrind gdb gdbserver \
	systemd-analyze \
	strace \
	jack-server jack-utils \
	nonlinear-nlaudio \
	nonlinear-rootfs-nuc \
	nonlinear-keyboard \
	"


update_config_files() {
  mv ${IMAGE_ROOTFS}/var/lib/alsa/asound.state.nonlinear ${IMAGE_ROOTFS}/var/lib/alsa/asound.state
}
IMAGE_PREPROCESS_COMMAND += "update_config_files;"


IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image
