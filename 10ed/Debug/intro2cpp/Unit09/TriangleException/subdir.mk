################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
D:/cpp/src/Unit09/TriangleException/AbstractGeometricObject.cpp \
D:/cpp/src/Unit09/TriangleException/TestTriangle.cpp 

OBJS += \
./intro2cpp/Unit09/TriangleException/AbstractGeometricObject.o \
./intro2cpp/Unit09/TriangleException/TestTriangle.o 

CPP_DEPS += \
./intro2cpp/Unit09/TriangleException/AbstractGeometricObject.d \
./intro2cpp/Unit09/TriangleException/TestTriangle.d 


# Each subdirectory must supply rules for building sources it contributes
intro2cpp/Unit09/TriangleException/AbstractGeometricObject.o: D:/cpp/src/Unit09/TriangleException/AbstractGeometricObject.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

intro2cpp/Unit09/TriangleException/TestTriangle.o: D:/cpp/src/Unit09/TriangleException/TestTriangle.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


