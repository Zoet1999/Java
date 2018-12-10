################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
D:/cpp/src/Unit05/CustomCopyConstructor/CustomCopyConstructor.cpp \
D:/cpp/src/Unit05/CustomCopyConstructor/Date1.cpp \
D:/cpp/src/Unit05/CustomCopyConstructor/Person1.cpp 

OBJS += \
./intro2cpp/Unit05/CustomCopyConstructor/CustomCopyConstructor.o \
./intro2cpp/Unit05/CustomCopyConstructor/Date1.o \
./intro2cpp/Unit05/CustomCopyConstructor/Person1.o 

CPP_DEPS += \
./intro2cpp/Unit05/CustomCopyConstructor/CustomCopyConstructor.d \
./intro2cpp/Unit05/CustomCopyConstructor/Date1.d \
./intro2cpp/Unit05/CustomCopyConstructor/Person1.d 


# Each subdirectory must supply rules for building sources it contributes
intro2cpp/Unit05/CustomCopyConstructor/CustomCopyConstructor.o: D:/cpp/src/Unit05/CustomCopyConstructor/CustomCopyConstructor.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

intro2cpp/Unit05/CustomCopyConstructor/Date1.o: D:/cpp/src/Unit05/CustomCopyConstructor/Date1.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

intro2cpp/Unit05/CustomCopyConstructor/Person1.o: D:/cpp/src/Unit05/CustomCopyConstructor/Person1.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


