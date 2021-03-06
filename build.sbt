name := "filter-bam"
version := "1.0.0"
description := "Filter BAMs to loci-intervals using Apache Spark."

sparkVersion := "1.6.1"

libraryDependencies ++= Seq(
  "org.hammerlab.adam" %% "adam-core" % "0.20.2",
  "com.esotericsoftware.kryo" % "kryo" % "2.21",
  "args4j" % "args4j" % "2.33",
  "org.hammerlab" %% "genomic-loci" % "1.4.0"
)

providedDeps ++= Seq(
  libraries.value('spark),
  "org.apache.hadoop" % "hadoop-client" % "2.6.0"
)

mainClass := Some("org.hammerlab.bams.FilterBam")

assemblyMergeStrategy in assembly := {
  // Two org.bdgenomics deps include the same log4j.properties.
  case PathList("log4j.properties") => MergeStrategy.first
  case x => (assemblyMergeStrategy in assembly).value(x)
}
