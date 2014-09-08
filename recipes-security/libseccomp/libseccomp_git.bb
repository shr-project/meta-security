SUMMARY = "interface to seccomp filtering mechanism"
DESCRIPTION = "The libseccomp library provides and easy to use, platform independent,interface to the Linux Kernel's syscall filtering mechanism: seccomp."
SECTION = "security"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRCREV="f6c219703e3e654e60bb341ab4de362a133fdba6"
SRC_URI = "git://git.code.sf.net/p/libseccomp/libseccomp;protocol=git \
"

inherit autotools-brokensep

S="${WORKDIR}/git"

do_configure_prepend () {

(
cat << 'EOF'
tests-build:
	${MAKE} ${AM_MAKEFLAGS} ${check_PROGRAMS}

tests-install:
	install ${check_PROGRAMS} ${DESTDIR}
	@list='$(check_PROGRAMS)'; \
		for p in $$list; do install $$p.tests ${DESTDIR}; done

	install regression testdiff testgen ${DESTDIR}

EOF
) >> tests/Makefile.am
}
do_compile_append() {
    oe_runmake -C tests tests-build
}

do_install() {
    install -d ${D}/${libdir}/${BPN}/tests
    oe_runmake -C tests DESTDIR=${D}/${libdir}/${BPN}/tests tests-install

    install -d ${D}/${libdir}/${BPN}/tools
    install tools/scmp_bpf_sim tools/scmp_arch_detect \
        tools/scmp_bpf_disasm tools/scmp_app_inspector \
        tools/check-syntax tools/scmp_sys_resolver ${D}/${libdir}/${BPN}/tools

}

PACKAGES += "${PN}-tests "
FILES_${PN}-tests = "tests/* tools/* "
FILES_${PN}-dbg += "${libdir}/${BPN}/tests/.debug/* ${libdir}/${BPN}/tools/.debug/*"
