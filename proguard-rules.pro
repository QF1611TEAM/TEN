# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/Rock/SoftWare/Android/Sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# 混淆原则
#jni方法不可混淆
#反射用到的类不混淆(否则反射可能出现问题)
#AndroidMainfest中的类不混淆，四大组件和Application的子类和Framework层下所有的类默认不会进行混淆
#Parcelable的子类和Creator静态成员变量不混淆，否则会产生android.os.BadParcelableException异常
#使用GSON、fastjson等框架时，所写的JSON对象类不混淆，否则无法将JSON解析成对应的对象
#使用第三方开源库或者引用其他第三方的SDK包时，需要在混淆文件中加入对应的混淆规则
#有用到WEBView的JS调用也需要保证写的接口方法不混淆

# 混淆语法
#-libraryjars class_path 应用的依赖包，如android-support-v4
#-keep [,modifier,...] class_specification 这里的keep就是保持的意思，意味着不混淆某些类
#-keepclassmembers [,modifier,...] class_specification 同样的保持，不混淆类的成员
#-keepclasseswithmembers [,modifier,...] class_specification 不混淆类及其成员
#-keepnames class_specification 不混淆类及其成员名
#-keepclassmembernames class_specification 不混淆类的成员名
#-keepclasseswithmembernames class_specification 不混淆类及其成员名
#-assumenosideeffects class_specification 假设调用不产生任何影响，在proguard代码优化时会将该调用remove掉。如system.out.println和Log.v等等
#-dontwarn [class_filter] 不提示warnning


#指定代码的压缩级别
-optimizationpasses 5

#包名不混合大小写
-dontusemixedcaseclassnames

#不去忽略非公共的库类
-dontskipnonpubliclibraryclasses

#优化  不优化输入的类文件
-dontoptimize

#预校验
-dontpreverify

#混淆时是否记录日志
-verbose

# 混淆时所采用的算法
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

#保护注解
-keepattributes *Annotation*

# -------------系统类不需要混淆 --------------------------
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.support.**
-keep public class com.android.vending.licensing.ILicensingService

# -----------------自己项目中混淆------------------- #


# ---------------------第三方库混淆--------------------------- #
