##############
# parameters #
##############
# do you want to show the commands executed ?
DO_MKDBG:=0
# do you want dependency on the Makefile itself ?
DO_ALLDEP:=1

#########
# rules #
#########
.PHONY: all
all:
	@true

.PHONY: clean
clean:
	$(Q)rm $(ALL)

.PHONY: clean_hard
clean_hard:
	$(Q)git clean -qffxd

##############
# parameters #
##############
# do you want to show the commands executed ?
DO_MKDBG:=0
# do you want dependency on the Makefile itself ?
DO_ALLDEP:=1

#########
# rules #
#########
