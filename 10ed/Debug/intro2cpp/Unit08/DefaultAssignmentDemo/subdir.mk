################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
D:/cpp/src/Unit08/DefaultAssignmentDemo/Date.cpp \
D:/cpp/src/Unit08/DefaultAssignmentDemo/DefaultAssignmentDemo.cpp \
D:/cpp/src/Unit08/DefaultAssignmentDemo/Person2.cpp 

OBJS += \
./intro2cpp/Unit08/DefaultAssignmentDemo/Date.o \
./intro2cpp/Unit08/DefaultAssignmentDemo/DefaultAssignmentDemo.o \
./intro2cpp/Unit08/DefaultAssignmentDemo/Person2.o 

CPP_DEPS += \
./intro2cpp/Unit08/DefaultAssignmentDemo/Date.d \
./intro2cpp/Unit08/DefaultAssignmentDemo/DefaultAssignmentDemo.d \
./intro2cpp/Unit08/DefaultAssignmentDemo/Person2.d 


# Each subdirectory must supply rules for building sources it contributes
intro2cpp/Unit08/DefaultAssignmentDemo/Date.o: D:/cpp/src/Unit08/DefaultAssignmentDemo/Date.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

intro2cpp/Unit08/DefaultAssignmentDemo/DefaultAssignmentDemo.o: D:/cpp/src/Unit08/DefaultAssignmentDemo/DefaultAssignmentDemo.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

intro2cpp/Unit08/DefaultAssignmentDemo/Person2.o: D:/cpp/src/Unit08/DefaultAssignmentDemo/Person2.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


