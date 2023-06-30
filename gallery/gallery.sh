#!/bin/bash
java -Xmx1024m -cp gallery.jar:lib/* photo.GalleryGenerator $@
