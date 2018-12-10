################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
D:/cpp/src/Unit07/BinaryIntOutput/BinaryIntOutput.cpp 

OBJS += \
./intro2cpp/Unit07/BinaryIntOutput/BinaryIntOutput.o 

CPP_DEPS += \
./intro2cpp/Unit07/BinaryIntOutput/BinaryIntOutput.d 


# Each subdirectory must supply rules for building sources it contributes
intro2cpp/Unit07/BinaryIntOutput/BinaryIntOutput.o: D:/cpp/src/Unit07/BinaryIntOutput/BinaryIntOutput.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


