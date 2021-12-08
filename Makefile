# **************************************************************************** #
#                                                                              #
#                                                         ::::::::             #
#    Makefile                                           :+:    :+:             #
#                                                      +:+                     #
#    By: aheister <aheister@student.codam.nl>         +#+                      #
#                                                    +#+                       #
#    Created: 2021/12/07 20:22:43 by aheister      #+#    #+#                  #
#    Updated: 2021/12/08 12:20:17 by aheister      ########   odam.nl          #
#                                                                              #
# **************************************************************************** #

NAME	= pandemic
JFLAGS	= -g
JC	= javac

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	checkNeighbours.java \
	iterateGrid.java \
	pandemic.java \
	printMap.java \
	rules.java	

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

re:
	$(MAKE) clean
	$(MAKE) default

.PHONY:	default clean re 