################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
D:/cpp/src/Unit08/TestNewRationalClass/NewRational.cpp \
D:/cpp/src/Unit08/TestNewRationalClass/TestNewRationalClass.cpp 

OBJS += \
./intro2cpp/Unit08/TestNewRationalClass/NewRational.o \
./intro2cpp/Unit08/TestNewRationalClass/TestNewRationalClass.o 

CPP_DEPS += \
./intro2cpp/Unit08/TestNewRationalClass/NewRational.d \
./intro2cpp/Unit08/TestNewRationalClass/TestNewRationalClass.d 


# Each subdirectory must supply rules for building sources it contributes
intro2cpp/Unit08/TestNewRationalClass/NewRational.o: D:/cpp/src/Unit08/TestNewRationalClass/NewRational.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

intro2cpp/Unit08/TestNewRationalClass/TestNewRationalClass.o: D:/cpp/src/Unit08/TestNewRationalClass/TestNewRationalClass.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


