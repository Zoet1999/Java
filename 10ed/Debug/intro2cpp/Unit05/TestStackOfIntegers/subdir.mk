################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
D:/cpp/src/Unit05/TestStackOfIntegers/StackOfIntegers.cpp \
D:/cpp/src/Unit05/TestStackOfIntegers/TestStackOfIntegers.cpp 

OBJS += \
./intro2cpp/Unit05/TestStackOfIntegers/StackOfIntegers.o \
./intro2cpp/Unit05/TestStackOfIntegers/TestStackOfIntegers.o 

CPP_DEPS += \
./intro2cpp/Unit05/TestStackOfIntegers/StackOfIntegers.d \
./intro2cpp/Unit05/TestStackOfIntegers/TestStackOfIntegers.d 


# Each subdirectory must supply rules for building sources it contributes
intro2cpp/Unit05/TestStackOfIntegers/StackOfIntegers.o: D:/cpp/src/Unit05/TestStackOfIntegers/StackOfIntegers.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

intro2cpp/Unit05/TestStackOfIntegers/TestStackOfIntegers.o: D:/cpp/src/Unit05/TestStackOfIntegers/TestStackOfIntegers.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


