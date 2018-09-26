SUMMARY = "Scripts and config glue for nonlinear devices"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL2.1;md5=4fbd65380cdd255951079008b364516c"
RDEPENDS_${PN} += "bash"

SRC_URI = "\
	file://home/root/.ssh/authorized_keys \
	file://etc/network/interfaces \
	file://boot/EFI/BOOT/grub.cfg \
	file://LICENSE.LGPL2.1 \
"

S = "${WORKDIR}"
FILES_${PN} = "/etc /home/root /mnt"
SRCREV = "${AUTOREV}"

do_install() {
  for dir in etc mnt home/root/.ssh; do
    rm -rf ${D}/${dir}
    install -d ${D}/${dir}
    cp -r ${WORKDIR}/${dir}/* ${D}/${dir}/
  done

  chmod 0600 ${D}/home/root/.ssh/authorized_keys

  # systemd services
  install -d ${D}/etc/systemd/system/multi-user.target.wants

  for service in \
    ; do

    ln -s ../${service}.service ${D}/etc/systemd/system/multi-user.target.wants/
  done

  for mount in \
    ; do

    ln -s ../${mount}.mount ${D}/etc/systemd/system/multi-user.target.wants/
  done
}
