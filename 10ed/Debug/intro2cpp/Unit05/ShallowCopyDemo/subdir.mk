################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
D:/cpp/src/Unit05/ShallowCopyDemo/Date.cpp \
D:/cpp/src/Unit05/ShallowCopyDemo/Person.cpp \
D:/cpp/src/Unit05/ShallowCopyDemo/ShallowCopyDemo.cpp 

OBJS += \
./intro2cpp/Unit05/ShallowCopyDemo/Date.o \
./intro2cpp/Unit05/ShallowCopyDemo/Person.o \
./intro2cpp/Unit05/ShallowCopyDemo/ShallowCopyDemo.o 

CPP_DEPS += \
./intro2cpp/Unit05/ShallowCopyDemo/Date.d \
./intro2cpp/Unit05/ShallowCopyDemo/Person.d \
./intro2cpp/Unit05/ShallowCopyDemo/ShallowCopyDemo.d 


# Each subdirectory must supply rules for building sources it contributes
intro2cpp/Unit05/ShallowCopyDemo/Date.o: D:/cpp/src/Unit05/ShallowCopyDemo/Date.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

intro2cpp/Unit05/ShallowCopyDemo/Person.o: D:/cpp/src/Unit05/ShallowCopyDemo/Person.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

intro2cpp/Unit05/ShallowCopyDemo/ShallowCopyDemo.o: D:/cpp/src/Unit05/ShallowCopyDemo/ShallowCopyDemo.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


