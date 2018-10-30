SUMMARY = "Scripts and config glue for nonlinear devices"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL2.1;md5=4fbd65380cdd255951079008b364516c"
RDEPENDS_${PN} += "bash"

SRC_URI = "\
	file://home/root/.ssh/authorized_keys \
	file://etc/systemd/network/wired.network \
	file://boot/EFI/BOOT/grub.cfg \
	file://var/lib/alsa/asound.state.nonlinear \
	file://LICENSE.LGPL2.1 \
"

S = "${WORKDIR}"
FILES_${PN} = "/etc/systemd/network /home/root /boot /var/lib/alsa"
SRCREV = "${AUTOREV}"

do_install() {
  for dir in home/root/.ssh boot etc/systemd/network var/lib/alsa; do
    rm -rf ${D}/${dir}
    install -d ${D}/${dir}
    cp -r ${WORKDIR}/${dir}/* ${D}/${dir}/
  done

  chmod 0600 ${D}/home/root/.ssh/authorized_keys
}
