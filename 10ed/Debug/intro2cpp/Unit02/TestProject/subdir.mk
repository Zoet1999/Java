################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
D:/cpp/src/Unit02/TestProject/main.cpp \
D:/cpp/src/Unit02/TestProject/未命名.cpp 

O_SRCS += \
D:/cpp/src/Unit02/TestProject/main.o \
D:/cpp/src/Unit02/TestProject/未命名.o 

OBJS += \
./intro2cpp/Unit02/TestProject/main.o \
./intro2cpp/Unit02/TestProject/未命名.o 

CPP_DEPS += \
./intro2cpp/Unit02/TestProject/main.d \
./intro2cpp/Unit02/TestProject/未命名.d 


# Each subdirectory must supply rules for building sources it contributes
intro2cpp/Unit02/TestProject/main.o: D:/cpp/src/Unit02/TestProject/main.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

intro2cpp/Unit02/TestProject/未命名.o: D:/cpp/src/Unit02/TestProject/未命名.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


