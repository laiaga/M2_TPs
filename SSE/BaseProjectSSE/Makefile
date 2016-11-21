


# Important definitions, most likely the ones you want to modify!

#choose platforms to build, choices : pic32mx795h
PLATFORM=pic32mx795h

# the base name of the module with your main function
MAIN=main

# the basenames of the modules you want to link into your project
PROJECT_DEPENDENCIES= init_system leddriver blink


#LIBRARIES
LIBRARIES=

#DEPENDENCIES
ifeq  ($(PLATFORM),pic32mx795h)

PROCESSOR=32MX795F512H
PIC32TOOLCHAIN=1
MYSCRIPT=p32MX795F512H.ld

HARMONY_DEPENDENCIES= system/devcon/src/sys_devcon system/devcon/src/sys_devcon_pic32mx


CFLAGS=   
endif


         
#INCLUDEPATH= -I./src -I./include

     
     
# default target
all:

deploy: all
	./pic32prog-pickit dist/$(MAIN).hex

# specify default target
.PHONY: all prequesites  harmony_symlink 
all: prequesites harmony_symlink



#TOOLCHAIN

ifdef PIC32TOOLCHAIN 
ifeq ($(OS),Windows_NT)
C32ROOT=C:\Program Files (x86)\Microchip\xc32\v1.34
else
UNAME =$(shell uname)
ifeq ($(UNAME),Darwin)
C32ROOT=/Applications/microchip/xc32/v1.34
HARMONYROOT=/Applications/microchip/harmony/v1_06
else
C32ROOT=/tmp/microchip/xc32/v1.34
HARMONYROOT=/tmp/microchip/harmony/v1_03_01
endif
endif

CC="$(C32ROOT)/bin/xc32-gcc"
AR="$(C32ROOT)/bin/xc32-ar"
RANLIB="$(C32ROOT)/bin/xc32-ranlib"
BIN2HEX="$(C32ROOT)/bin/xc32-bin2hex"


# test pour l'installation du compilateur et installation dans /tmp, si nécessaire
prequesites:
	@if test -f $(CC); then echo xc32 et harmony sont installés ; else  echo installe xc32 et harmony ; \
      cd /tmp ; \
      wget http://pageperso.lif.univ-mrs.fr/~peter.niebert/SE/res/microchip.tgz ; \
      tar zxf microchip.tgz ; \
      /bin/rm microchip.tgz ; \
      echo installe libusb ; \
      wget http://pageperso.lif.univ-mrs.fr/~peter.niebert/SE/res/libusb.tar.gz ; \
      tar zxf libusb.tar.gz ; \
      /bin/rm libusb.tar.gz ; \
    fi



harmony_symlink:
	@rm -f src/harmony
	@ln -s $(HARMONYROOT)/framework src/harmony





CFLAGS+= -I $(HARMONYROOT)/framework

LDSCRIPT=--script=src/$(MYSCRIPT)
LDFLAGS= $(LDSCRIPT)

endif

DEPENDENCIES= $(PROJECT_DEPENDENCIES:%=%.o) $(HARMONY_DEPENDENCIES:%=harmony/%.o)


#default optimisation level
ifndef $(OPTIMISATIONLEVEL)
OPTIMISATIONLEVEL=2 -fira-loop-pressure -fpredictive-commoning 
# 2 -fira-loop-pressure -fpredictive-commoning
endif

# compilation options

INCLUDEPATH+= -I./src -I./include
CFLAGS+= $(INCLUDEPATH) -g -O$(OPTIMISATIONLEVEL) -fno-keep-inline-functions -mprocessor=$(PROCESSOR)



#
# rules
#


build/%.o:src/%.c
	mkdir -p $(dir $@)
	@echo "Compiling $< ..."
	$(CC) -c  -x c  $(DEFINE) $(CFLAGS) -o $@ -MMD -MF $@.d  $<

build/%.o:src/%.s
	mkdir -p $(dir $@)
	@echo "Assembling $< ..."
	$(CC) -DMASTER -c   $(DEFINE) $(CFLAGS) -o $@  $<
	
	

dist/%.elf:build/%.o $(DEPENDENCIES:%=build/%) src/$(MYSCRIPT)
	mkdir -p $(dir $@)
	@echo "linking $@"
	$(CC) $(CFLAGS) $<  $(DEPENDENCIES:%=build/%)   $(LIBRARIES) -Wl,$(LDFLAGS),-Map=$@.map -o $@
	



#
# binary stripped of symbols in HEX format
#
%.hex:%.elf
	@echo "generating HEX file for $<"
	$(BIN2HEX) -v $<


all: dist/$(MAIN).elf dist/$(MAIN).hex

##### paths and cleanup


clean:
	@echo "cleaning"
	rm -rf build/* dist/*
