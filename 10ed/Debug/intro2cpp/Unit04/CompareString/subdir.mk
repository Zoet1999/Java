################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
D:/cpp/src/Unit04/CompareString/CompareString.cpp 

O_SRCS += \
D:/cpp/src/Unit04/CompareString/CompareString.o 

OBJS += \
./intro2cpp/Unit04/CompareString/CompareString.o 

CPP_DEPS += \
./intro2cpp/Unit04/CompareString/CompareString.d 


# Each subdirectory must supply rules for building sources it contributes
intro2cpp/Unit04/CompareString/CompareString.o: D:/cpp/src/Unit04/CompareString/CompareString.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


