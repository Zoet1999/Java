################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
D:/cpp/src/Unit07/RandomAccessFile/RandomAccessFile.cpp \
D:/cpp/src/Unit07/RandomAccessFile/Student.cpp 

OBJS += \
./intro2cpp/Unit07/RandomAccessFile/RandomAccessFile.o \
./intro2cpp/Unit07/RandomAccessFile/Student.o 

CPP_DEPS += \
./intro2cpp/Unit07/RandomAccessFile/RandomAccessFile.d \
./intro2cpp/Unit07/RandomAccessFile/Student.d 


# Each subdirectory must supply rules for building sources it contributes
intro2cpp/Unit07/RandomAccessFile/RandomAccessFile.o: D:/cpp/src/Unit07/RandomAccessFile/RandomAccessFile.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

intro2cpp/Unit07/RandomAccessFile/Student.o: D:/cpp/src/Unit07/RandomAccessFile/Student.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


