################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
D:/cpp/src/Unit04/AlohaWorld/main.cpp 

OBJS += \
./intro2cpp/Unit04/AlohaWorld/main.o 

CPP_DEPS += \
./intro2cpp/Unit04/AlohaWorld/main.d 


# Each subdirectory must supply rules for building sources it contributes
intro2cpp/Unit04/AlohaWorld/main.o: D:/cpp/src/Unit04/AlohaWorld/main.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


