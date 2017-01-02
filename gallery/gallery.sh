#!/bin/bash
java -Xmx512m -cp gallery.jar:lib/* photo.GalleryGenerator $@
