################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
D:/cpp/src/Unit01/Alohaworld1/AlohaWorld.cpp \
D:/cpp/src/Unit01/Alohaworld1/DisplayMessage.cpp 

OBJS += \
./intro2cpp/Unit01/Alohaworld1/AlohaWorld.o \
./intro2cpp/Unit01/Alohaworld1/DisplayMessage.o 

CPP_DEPS += \
./intro2cpp/Unit01/Alohaworld1/AlohaWorld.d \
./intro2cpp/Unit01/Alohaworld1/DisplayMessage.d 


# Each subdirectory must supply rules for building sources it contributes
intro2cpp/Unit01/Alohaworld1/AlohaWorld.o: D:/cpp/src/Unit01/Alohaworld1/AlohaWorld.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

intro2cpp/Unit01/Alohaworld1/DisplayMessage.o: D:/cpp/src/Unit01/Alohaworld1/DisplayMessage.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


