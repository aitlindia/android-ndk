#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_alam_myapplication_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}


extern "C" JNIEXPORT jint JNICALL
Java_com_example_alam_myapplication_MainActivity_intFromJNI(
        JNIEnv *env,
        jobject, jint value /* this */) {
    jint mydefault = 99 + value;

    return mydefault;
}


extern "C" JNIEXPORT jint JNICALL
Java_com_example_alam_myapplication_MainActivity_intSumFromJNI(
        JNIEnv *env,
        jobject, jint value1, jint value2 /* this */) {
    jint sum = value1 + value2;
    return sum;
}

