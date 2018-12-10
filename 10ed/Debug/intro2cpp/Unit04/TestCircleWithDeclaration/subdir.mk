################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
D:/cpp/src/Unit04/TestCircleWithDeclaration/Circle.cpp \
D:/cpp/src/Unit04/TestCircleWithDeclaration/TestCircleWithDeclaration.cpp \
D:/cpp/src/Unit04/TestCircleWithDeclaration/temp.cpp 

OBJS += \
./intro2cpp/Unit04/TestCircleWithDeclaration/Circle.o \
./intro2cpp/Unit04/TestCircleWithDeclaration/TestCircleWithDeclaration.o \
./intro2cpp/Unit04/TestCircleWithDeclaration/temp.o 

CPP_DEPS += \
./intro2cpp/Unit04/TestCircleWithDeclaration/Circle.d \
./intro2cpp/Unit04/TestCircleWithDeclaration/TestCircleWithDeclaration.d \
./intro2cpp/Unit04/TestCircleWithDeclaration/temp.d 


# Each subdirectory must supply rules for building sources it contributes
intro2cpp/Unit04/TestCircleWithDeclaration/Circle.o: D:/cpp/src/Unit04/TestCircleWithDeclaration/Circle.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

intro2cpp/Unit04/TestCircleWithDeclaration/TestCircleWithDeclaration.o: D:/cpp/src/Unit04/TestCircleWithDeclaration/TestCircleWithDeclaration.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

intro2cpp/Unit04/TestCircleWithDeclaration/temp.o: D:/cpp/src/Unit04/TestCircleWithDeclaration/temp.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


