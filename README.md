# RxAndroidOrm


<a href="https://goo.gl/WXW8Dc">
  <img alt="Android app on Google Play" src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>


# Download

<a href='https://ko-fi.com/A160LCC' target='_blank'><img height='36' style='border:0px;height:36px;' src='https://az743702.vo.msecnd.net/cdn/kofi1.png?v=0' border='0' alt='Buy Me a Coffee at ko-fi.com' /></a>

[ ![Download](https://api.bintray.com/packages/florent37/maven/rxandroidorm-compiler/images/download.svg) ](https://bintray.com/florent37/maven/rxandroidorm-compiler/_latestVersion)
```java
dependencies {
    compile 'com.github.florent37:rxandroidorm:1.0.1'
    provided 'com.github.florent37:rxandroidorm-annotations:1.0.1'
    annotationProcessor 'com.github.florent37:rxandroidorm-compiler:1.0.1'
}
```

A simple & fluent Android ORM, how can it be easier ?
And it's compatible with RxJava2 !

```java
Observable.fromArray(
                new Computer(Computer.WINDOWS, "MasterRace", Arrays.asList(new Software("Photoshop"))),
                new Computer(Computer.WINDOWS, "Gamerz"),
                new Computer(Computer.LINUX, "MasterRace", Arrays.asList(new Software("Gimp"))))
                .flatMap(computerDb::add)
                .subscribe();

Observable.just(new Computer(Computer.MAC, "Mac Mini"))
                .flatMap(computerDb::add)
                .doOnNext(computer -> computer.getSoftwares().add(new Software("Photoshop")))
                .flatMap(computerDb::update)
                .subscribe();

computerDb.select()
                .label().equalsTo("MasterRace")
                .or()
                .softwares(SoftwareDatabase.where().name().equalsTo("Photoshop"))

                .asObservable()
                .subscribe(computers -> Log.d(TAG, computers.toString()));
```

# First, initialize !

Don't forget to initialise RxAndroidOrm in your applicarion:

```java
public class MyApplicarion extends Applicarion {

    @Override public void onCreate() {
        super.onCreate();
        RxAndroidOrm.onCreate(this);
    }

}
```

# Second, annotate your models

Use Annotations to mark classes to be persisted:

```java
@Model
public class Computer {

    @Id long id;
    String name;
   
    List<Software> softwares;
}
```

## Logging

You can log all SQL queries from entities managers:

```java
computerDb.logQueries((query, datas) -> Log.d(TAG, query) }
```

# TODO

- Enum support

# Credits

Author: Florent Champigny [http://www.florentchampigny.com/](http://www.florentchampigny.com/)

Blog : [http://www.tutos-android-france.com/](http://www.www.tutos-android-france.com/)


<a href="https://goo.gl/WXW8Dc">
  <img alt="Android app on Google Play" src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>

<a href="https://plus.google.com/+florentchampigny">
  <img alt="Follow me on Google+"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/gplus.png" />
</a>
<a href="https://twitter.com/florent_champ">
  <img alt="Follow me on Twitter"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/twitter.png" />
</a>
<a href="https://www.linkedin.com/in/florentchampigny">
  <img alt="Follow me on LinkedIn"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/linkedin.png" />
</a>


License
--------

    Copyright 2017 Florent37, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

