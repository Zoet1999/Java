################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
D:/cpp/src/Unit03/DefaultArgumentDemo/DefaultArgumentDemo.cpp 

OBJS += \
./intro2cpp/Unit03/DefaultArgumentDemo/DefaultArgumentDemo.o 

CPP_DEPS += \
./intro2cpp/Unit03/DefaultArgumentDemo/DefaultArgumentDemo.d 


# Each subdirectory must supply rules for building sources it contributes
intro2cpp/Unit03/DefaultArgumentDemo/DefaultArgumentDemo.o: D:/cpp/src/Unit03/DefaultArgumentDemo/DefaultArgumentDemo.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


