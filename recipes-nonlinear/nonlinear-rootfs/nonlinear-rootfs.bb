SUMMARY = "Scripts and config glue for nonlinear devices"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL2.1;md5=4fbd65380cdd255951079008b364516c"
RDEPENDS_${PN} += "bash"

SRC_URI = "\
	file://mnt/usb-stick/.not-mounted \
	file://home/root/.ssh/authorized_keys \
	file://nonlinear/scripts/install-update.sh \
	file://nonlinear/scripts/time.sh \
	file://etc/udev/rules.d/100-accesspoint.rules \
	file://etc/udev/rules.d/100-gether.rules \
	file://etc/udev/rules.d/100-usbnet.rules \
	file://etc/dhcpd-usbnet.conf \
	file://etc/dhcpd-wlan.conf \
	file://etc/systemd/system/internalstorage.mount \
	file://etc/systemd/system/accesspoint.service \
	file://etc/systemd/system/dhcpd-wlan.service \
	file://etc/systemd/system/dhcpd-usbnet.service \
	file://etc/systemd/system/usbnet.service \
	file://etc/hostapd.conf.nonlinear \
	file://etc/network/interfaces \
	file://etc/profile.d/add_playground_path.sh \
	file://etc/ssh/sshd_config.nonlinear \
	file://LICENSE.LGPL2.1 \
"

S = "${WORKDIR}"
FILES_${PN} = "/etc /nonlinear /home/root /nonlinear/scripts /mnt"
SRCREV = "${AUTOREV}"

do_install() {
  for dir in etc nonlinear/scripts mnt home/root/.ssh; do
    rm -rf ${D}/${dir}
    install -d ${D}/${dir}
    cp -r ${WORKDIR}/${dir}/* ${D}/${dir}/
  done

  chmod 0600 ${D}/home/root/.ssh/authorized_keys

  # systemd services
  install -d ${D}/etc/systemd/system/multi-user.target.wants

  for service in \
	bbbb \
	playground \
    ; do

    ln -s ../${service}.service ${D}/etc/systemd/system/multi-user.target.wants/
  done

  for mount in \
	internalstorage \
    ; do

    ln -s ../${mount}.mount ${D}/etc/systemd/system/multi-user.target.wants/
  done
}
