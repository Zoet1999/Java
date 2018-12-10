################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
D:/cpp/src/Unit06/TestFruit/Apple.cpp \
D:/cpp/src/Unit06/TestFruit/Fruit.cpp \
D:/cpp/src/Unit06/TestFruit/TestFruit.cpp 

OBJS += \
./intro2cpp/Unit06/TestFruit/Apple.o \
./intro2cpp/Unit06/TestFruit/Fruit.o \
./intro2cpp/Unit06/TestFruit/TestFruit.o 

CPP_DEPS += \
./intro2cpp/Unit06/TestFruit/Apple.d \
./intro2cpp/Unit06/TestFruit/Fruit.d \
./intro2cpp/Unit06/TestFruit/TestFruit.d 


# Each subdirectory must supply rules for building sources it contributes
intro2cpp/Unit06/TestFruit/Apple.o: D:/cpp/src/Unit06/TestFruit/Apple.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

intro2cpp/Unit06/TestFruit/Fruit.o: D:/cpp/src/Unit06/TestFruit/Fruit.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

intro2cpp/Unit06/TestFruit/TestFruit.o: D:/cpp/src/Unit06/TestFruit/TestFruit.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


