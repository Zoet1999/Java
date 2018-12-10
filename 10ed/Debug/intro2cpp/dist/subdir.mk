################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
D:/cpp/src/dist/distance.cpp 

O_SRCS += \
D:/cpp/src/dist/distance.o 

OBJS += \
./intro2cpp/dist/distance.o 

CPP_DEPS += \
./intro2cpp/dist/distance.d 


# Each subdirectory must supply rules for building sources it contributes
intro2cpp/dist/distance.o: D:/cpp/src/dist/distance.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


