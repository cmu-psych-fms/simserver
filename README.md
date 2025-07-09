# Similarity Service and Client

This is a Lisp wrapper around some Java code from UMBC for computing the semantic
similarity of pieces of text.
Both the client and server are in the same file, `similarity-service.lisp`.

The UMBC code and accompanying date are rather large, far too large to fit into GitHub. While in principle
GitHub LFS (large file system) might be able to deal with this, it’s really quite painful, doubly so if
all you really care about is the client. So the only stuff
committed to this repo is the easy, CMU written stuff; if needed the UMBC stuff will have to acquired out of band
in some way, probably just copied from Mneme. The full directory tree for the server version is at
the end of this document.

## Client

Ensure you are running a Common Lisp (primarily tested with SBCL) that
can grab things from QuickLisp, and just load `similarity-service.lisp`.
That should load all the dependencies via QuickLisp.
The primary entry point is `ss:cached-semantic-textual-similarity`, with its third argument true.

Note that the UMBC is *not* needed if all you care about is the client.

## Server

To install the server

- make sure you’ve got all the UMBC stuff

- open port 9543 in the firewall

- ensure the value of `*default-host*` reflects the machine it will be running on

- ensure the values of ``User`, WorkingDirectory` and `ExecStart` are correct in `similarityService.service`

- copy the contents of the `sts` directory to `/usr/share/sts/`

- load `similarity-service.lisp` into SBCL or CCL and call `ss:make-executable`

- enable and start the `similarityService.service` file

## Directory structure

Here’s the structure of the full server directory with all the UMBC stuff, including file sizes in bytes:

    [       4096]  .
    ├── [     421398]  emails.csv
    ├── [     569231]  joda-time.jar
    ├── [    4167782]  similarity.jar
    ├── [       1111]  SimilarityMain.class
    ├── [        835]  SimilarityMain.java
    ├── [   66763592]  similarity-server
    ├── [        330]  similarityServer.service
    ├── [       5903]  similarity-service.lisp
    ├── [       4096]  sts
    │   ├── [         57]  AntonymsLexicon
    │   ├── [ 1638429412]  webbase2012AllPlusW5_S3.BigArray_model
    │   └── [       4096]  wsj-bidirectional
    │       ├── [   32413495]  wsj-0-18-bidirectional-distsim.tagger
    │       └── [       1376]  wsj-0-18-bidirectional-distsim.tagger.props
    ├── [       4096]  umbc_sts
    │   ├── [       1478]  readme.txt
    │   └── [       4096]  StsService
    │       ├── [       4139]  api.html
    │       ├── [          0]  error.jsp
    │       ├── [       1450]  index.html
    │       ├── [      15965]  logo.jpg
    │       ├── [       4096]  src
    │       ├── [       1450]  sts.html
    │       ├── [       1273]  sts_single_type.html
    │       ├── [       1300]  sts_single_type.template
    │       ├── [       1337]  sts.template
    │       ├── [       4096]  StyleSheets
    │       │   └── [       2087]  render.css
    │       ├── [       4096]  WEB-INF
    │       │   ├── [       4096]  classes
    │       │   │   ├── [       4096]  com
    │       │   │   │   └── [       4096]  mdimension
    │       │   │   │       └── [       4096]  jchronic
    │       │   │   │           ├── [       5787]  Chronic.class
    │       │   │   │           ├── [       4096]  handlers
    │       │   │   │           │   ├── [        877]  DummyHandler.class
    │       │   │   │           │   ├── [       1386]  Handler$HandlerType.class
    │       │   │   │           │   ├── [      17724]  Handler.class
    │       │   │   │           │   ├── [        488]  HandlerPattern.class
    │       │   │   │           │   ├── [       1003]  HandlerTypePattern.class
    │       │   │   │           │   ├── [        386]  IHandler.class
    │       │   │   │           │   ├── [       2518]  MDHandler.class
    │       │   │   │           │   ├── [       1210]  ORGRHandler.class
    │       │   │   │           │   ├── [       2455]  ORRHandler.class
    │       │   │   │           │   ├── [       1210]  ORSRHandler.class
    │       │   │   │           │   ├── [       1143]  PSRHandler.class
    │       │   │   │           │   ├── [       2557]  RdnRmnSdTTzSyHandler.class
    │       │   │   │           │   ├── [       1141]  RGRHandler.class
    │       │   │   │           │   ├── [       1088]  RHandler.class
    │       │   │   │           │   ├── [       1474]  RmnOdHandler.class
    │       │   │   │           │   ├── [       1473]  RmnSdHandler.class
    │       │   │   │           │   ├── [       2561]  RmnSdSyHandler.class
    │       │   │   │           │   ├── [       2317]  RmnSyHandler.class
    │       │   │   │           │   ├── [       1296]  SdRmnSyHandler.class
    │       │   │   │           │   ├── [       1292]  SdSmSyHandler.class
    │       │   │   │           │   ├── [       1820]  SmSdHandler.class
    │       │   │   │           │   ├── [       2417]  SmSdSyHandler.class
    │       │   │   │           │   ├── [       2173]  SmSyHandler.class
    │       │   │   │           │   ├── [       1232]  SRPAHandler.class
    │       │   │   │           │   ├── [       2673]  SRPHandler.class
    │       │   │   │           │   ├── [       1292]  SySmSdHandler.class
    │       │   │   │           │   └── [       1386]  TagPattern.class
    │       │   │   │           ├── [       4096]  numerizer
    │       │   │   │           │   ├── [        905]  Numerizer$BigPrefix.class
    │       │   │   │           │   ├── [        934]  Numerizer$DirectNum.class
    │       │   │   │           │   ├── [        779]  Numerizer$Prefix.class
    │       │   │   │           │   ├── [        928]  Numerizer$TenPrefix.class
    │       │   │   │           │   └── [       6393]  Numerizer.class
    │       │   │   │           ├── [       2728]  Options.class
    │       │   │   │           ├── [       4096]  repeaters
    │       │   │   │           │   ├── [       2560]  EnumRepeaterDayPortion.class
    │       │   │   │           │   ├── [       1218]  IntegerRepeaterDayPortion.class
    │       │   │   │           │   ├── [       4618]  Repeater.class
    │       │   │   │           │   ├── [       2756]  RepeaterDay.class
    │       │   │   │           │   ├── [       1543]  RepeaterDayName$DayName.class
    │       │   │   │           │   ├── [       5050]  RepeaterDayName.class
    │       │   │   │           │   ├── [       1525]  RepeaterDayPortion$DayPortion.class
    │       │   │   │           │   ├── [       6453]  RepeaterDayPortion.class
    │       │   │   │           │   ├── [       3721]  RepeaterFortnight.class
    │       │   │   │           │   ├── [       2867]  RepeaterHour.class
    │       │   │   │           │   ├── [       2866]  RepeaterMinute.class
    │       │   │   │           │   ├── [       2788]  RepeaterMonth.class
    │       │   │   │           │   ├── [       1878]  RepeaterMonthName$MonthName.class
    │       │   │   │           │   ├── [       6004]  RepeaterMonthName.class
    │       │   │   │           │   ├── [       1679]  RepeaterSeason.class
    │       │   │   │           │   ├── [       1895]  RepeaterSeasonName.class
    │       │   │   │           │   ├── [       2191]  RepeaterSecond.class
    │       │   │   │           │   ├── [       7870]  RepeaterTime.class
    │       │   │   │           │   ├── [       1665]  RepeaterUnit$UnitName.class
    │       │   │   │           │   ├── [       3973]  RepeaterUnit.class
    │       │   │   │           │   ├── [       3886]  RepeaterWeek.class
    │       │   │   │           │   ├── [       3523]  RepeaterWeekend.class
    │       │   │   │           │   └── [       2912]  RepeaterYear.class
    │       │   │   │           ├── [       4096]  tags
    │       │   │   │           │   ├── [       1238]  Grabber$Relative.class
    │       │   │   │           │   ├── [       3237]  Grabber.class
    │       │   │   │           │   ├── [       2589]  Ordinal.class
    │       │   │   │           │   ├── [       1653]  OrdinalDay.class
    │       │   │   │           │   ├── [       1261]  Pointer$PointerType.class
    │       │   │   │           │   ├── [       3266]  Pointer.class
    │       │   │   │           │   ├── [       3601]  Scalar.class
    │       │   │   │           │   ├── [       2187]  ScalarDay.class
    │       │   │   │           │   ├── [       2199]  ScalarMonth.class
    │       │   │   │           │   ├── [       2249]  ScalarYear.class
    │       │   │   │           │   ├── [       1432]  Separator$SeparatorType.class
    │       │   │   │           │   ├── [       2440]  SeparatorAt.class
    │       │   │   │           │   ├── [       2602]  Separator.class
    │       │   │   │           │   ├── [       2456]  SeparatorComma.class
    │       │   │   │           │   ├── [       2436]  SeparatorIn.class
    │       │   │   │           │   ├── [       2660]  SeparatorSlashOrDash.class
    │       │   │   │           │   ├── [        488]  StringTag.class
    │       │   │   │           │   ├── [       1128]  Tag.class
    │       │   │   │           │   └── [       2634]  TimeZone.class
    │       │   │   │           └── [       4096]  utils
    │       │   │   │               ├── [       1167]  Range.class
    │       │   │   │               ├── [       1975]  Span.class
    │       │   │   │               ├── [       1041]  StringUtils.class
    │       │   │   │               ├── [       1304]  Tick.class
    │       │   │   │               ├── [       3167]  Time.class
    │       │   │   │               └── [       3212]  Token.class
    │       │   │   └── [       4096]  edu
    │       │   │       ├── [       4096]  stanford
    │       │   │       │   └── [       4096]  nlp
    │       │   │       │       ├── [       4096]  classify
    │       │   │       │       │   ├── [       3923]  AbstractLinearClassifierFactory.class
    │       │   │       │       │   ├── [       3538]  AdaptedGaussianPriorObjectiveFunction.class
    │       │   │       │       │   ├── [       4301]  BiasedLogConditionalObjectiveFunction.class
    │       │   │       │       │   ├── [        639]  Classifier.class
    │       │   │       │       │   ├── [        357]  ClassifierCreator.class
    │       │   │       │       │   ├── [        725]  ClassifierFactory.class
    │       │   │       │       │   ├── [       2667]  CrossValidator$CrossValidationIterator.class
    │       │   │       │       │   ├── [        468]  CrossValidator$SavedState.class
    │       │   │       │       │   ├── [       4455]  CrossValidator.class
    │       │   │       │       │   ├── [      25546]  Dataset.class
    │       │   │       │       │   ├── [       1415]  GeneralDataset$1.class
    │       │   │       │       │   ├── [      13599]  GeneralDataset.class
    │       │   │       │       │   ├── [       9496]  GeneralizedExpectationObjectiveFunction.class
    │       │   │       │       │   ├── [      41839]  LinearClassifier.class
    │       │   │       │       │   ├── [       3428]  LinearClassifierFactory$1.class
    │       │   │       │       │   ├── [       2311]  LinearClassifierFactory$2.class
    │       │   │       │       │   ├── [       2847]  LinearClassifierFactory$LinearClassifierCreator.class
    │       │   │       │       │   ├── [       3520]  LinearClassifierFactory$NegativeScorer.class
    │       │   │       │       │   ├── [      33812]  LinearClassifierFactory.class
    │       │   │       │       │   ├── [      19636]  LogConditionalObjectiveFunction.class
    │       │   │       │       │   ├── [       1464]  LogPrior$LogPriorType.class
    │       │   │       │       │   ├── [       7081]  LogPrior.class
    │       │   │       │       │   ├── [       3079]  NBLinearClassifierFactory$1.class
    │       │   │       │       │   ├── [       4735]  NBLinearClassifierFactory.class
    │       │   │       │       │   ├── [      10306]  PRCurve.class
    │       │   │       │       │   ├── [        538]  ProbabilisticClassifier.class
    │       │   │       │       │   ├── [        422]  ProbabilisticClassifierCreator.class
    │       │   │       │       │   ├── [        573]  RVFClassifier.class
    │       │   │       │       │   ├── [       1532]  RVFDataset$1.class
    │       │   │       │       │   ├── [      28109]  RVFDataset.class
    │       │   │       │       │   ├── [       2181]  SemiSupervisedLogConditionalObjectiveFunction.class
    │       │   │       │       │   ├── [       3408]  SVMLightClassifier.class
    │       │   │       │       │   ├── [       3027]  SVMLightClassifierFactory$1.class
    │       │   │       │       │   ├── [       2307]  SVMLightClassifierFactory$2.class
    │       │   │       │       │   ├── [       2142]  SVMLightClassifierFactory$3.class
    │       │   │       │       │   ├── [      21695]  SVMLightClassifierFactory.class
    │       │   │       │       │   └── [       4140]  WeightedDataset.class
    │       │   │       │       ├── [       4096]  dcoref
    │       │   │       │       │   ├── [       1366]  ACEMentionExtractor$EntityComparator.class
    │       │   │       │       │   ├── [      13700]  ACEMentionExtractor.class
    │       │   │       │       │   ├── [        842]  CoNLL2011DocumentReader$CorefMentionAnnotation.class
    │       │   │       │       │   ├── [       9069]  CoNLL2011DocumentReader$CorpusStats.class
    │       │   │       │       │   ├── [       2444]  CoNLL2011DocumentReader$Document.class
    │       │   │       │       │   ├── [      19667]  CoNLL2011DocumentReader$DocumentIterator.class
    │       │   │       │       │   ├── [        839]  CoNLL2011DocumentReader$NamedEntityAnnotation.class
    │       │   │       │       │   ├── [       1343]  CoNLL2011DocumentReader$Options.class
    │       │   │       │       │   ├── [      16198]  CoNLL2011DocumentReader.class
    │       │   │       │       │   ├── [      12985]  CoNLLMentionExtractor.class
    │       │   │       │       │   ├── [       3955]  Constants.class
    │       │   │       │       │   ├── [       4123]  CorefChain$CorefMention.class
    │       │   │       │       │   ├── [       1213]  CorefChain$MentionComparator.class
    │       │   │       │       │   ├── [       4214]  CorefChain.class
    │       │   │       │       │   ├── [      16926]  CorefCluster.class
    │       │   │       │       │   ├── [        770]  CorefCoreAnnotations$CorefAnnotation.class
    │       │   │       │       │   ├── [       1024]  CorefCoreAnnotations$CorefChainAnnotation.class
    │       │   │       │       │   ├── [        986]  CorefCoreAnnotations$CorefClusterAnnotation.class
    │       │   │       │       │   ├── [        800]  CorefCoreAnnotations$CorefClusterIdAnnotation.class
    │       │   │       │       │   ├── [        824]  CorefCoreAnnotations$CorefDestAnnotation.class
    │       │   │       │       │   ├── [       1105]  CorefCoreAnnotations$CorefGraphAnnotation.class
    │       │   │       │       │   ├── [        968]  CorefCoreAnnotations.class
    │       │   │       │       │   ├── [        445]  CorefMentionFinder.class
    │       │   │       │       │   ├── [        867]  coref.properties
    │       │   │       │       │   ├── [       1243]  CorefScorer$ScoreType.class
    │       │   │       │       │   ├── [       2824]  CorefScorer.class
    │       │   │       │       │   ├── [       1243]  Dictionaries$Animacy.class
    │       │   │       │       │   ├── [       1280]  Dictionaries$Gender.class
    │       │   │       │       │   ├── [       1271]  Dictionaries$MentionType.class
    │       │   │       │       │   ├── [       1234]  Dictionaries$Number.class
    │       │   │       │       │   ├── [       1457]  Dictionaries$Person.class
    │       │   │       │       │   ├── [      21013]  Dictionaries.class
    │       │   │       │       │   ├── [       1164]  Document$DocType.class
    │       │   │       │       │   ├── [      25880]  Document.class
    │       │   │       │       │   ├── [      36895]  Mention.class
    │       │   │       │       │   ├── [      17147]  MentionExtractor.class
    │       │   │       │       │   ├── [      11842]  MUCMentionExtractor.class
    │       │   │       │       │   ├── [      23538]  RuleBasedCorefMentionFinder.class
    │       │   │       │       │   ├── [       1350]  ScorerBCubed$BCubedType.class
    │       │   │       │       │   ├── [       6862]  ScorerBCubed.class
    │       │   │       │       │   ├── [       3612]  ScorerMUC.class
    │       │   │       │       │   ├── [       3307]  ScorerPairwise.class
    │       │   │       │       │   ├── [       1042]  Semantics.class
    │       │   │       │       │   ├── [        952]  SieveCoreferenceSystem$LogFormatter.class
    │       │   │       │       │   ├── [      46225]  SieveCoreferenceSystem.class
    │       │   │       │       │   ├── [       2842]  SieveOptions.class
    │       │   │       │       │   └── [       4096]  sievepasses
    │       │   │       │       │       ├── [        688]  AliasMatch.class
    │       │   │       │       │       ├── [      19018]  DeterministicCorefSieve.class
    │       │   │       │       │       ├── [        534]  DiscourseMatch.class
    │       │   │       │       │       ├── [        542]  ExactStringMatch.class
    │       │   │       │       │       ├── [        754]  LexicalChainMatch.class
    │       │   │       │       │       ├── [        511]  MarkRole.class
    │       │   │       │       │       ├── [        747]  PreciseConstructs.class
    │       │   │       │       │       ├── [        557]  PronounMatch.class
    │       │   │       │       │       ├── [        571]  RelaxedExactStringMatch.class
    │       │   │       │       │       ├── [        669]  RelaxedHeadMatch.class
    │       │   │       │       │       ├── [        676]  StrictHeadMatch1.class
    │       │   │       │       │       ├── [        626]  StrictHeadMatch2.class
    │       │   │       │       │       ├── [        632]  StrictHeadMatch3.class
    │       │   │       │       │       └── [        722]  StrictHeadMatch4.class
    │       │   │       │       ├── [       4096]  fsm
    │       │   │       │       │   ├── [        240]  AutomatonMinimizer.class
    │       │   │       │       │   ├── [        249]  Block.class
    │       │   │       │       │   ├── [       7511]  DFSA.class
    │       │   │       │       │   ├── [       5848]  DFSAState.class
    │       │   │       │       │   ├── [       2682]  DFSATransition.class
    │       │   │       │       │   ├── [        637]  FastExactAutomatonMinimizer$Block.class
    │       │   │       │       │   ├── [       1208]  FastExactAutomatonMinimizer$Split.class
    │       │   │       │       │   ├── [      10907]  FastExactAutomatonMinimizer.class
    │       │   │       │       │   ├── [       5702]  QuasiDeterminizer.class
    │       │   │       │       │   ├── [       3600]  TransducerGraph$Arc.class
    │       │   │       │       │   ├── [        403]  TransducerGraph$ArcProcessor.class
    │       │   │       │       │   ├── [        341]  TransducerGraph$GraphProcessor.class
    │       │   │       │       │   ├── [       1171]  TransducerGraph$InputSplittingProcessor.class
    │       │   │       │       │   ├── [        298]  TransducerGraph$NodeProcessor.class
    │       │   │       │       │   ├── [       1427]  TransducerGraph$NodeProcessorWrappingArcProcessor.class
    │       │   │       │       │   ├── [       2094]  TransducerGraph$NormalizingGraphProcessor.class
    │       │   │       │       │   ├── [        785]  TransducerGraph$ObjectToSetNodeProcessor.class
    │       │   │       │       │   ├── [       1178]  TransducerGraph$OutputCombiningProcessor.class
    │       │   │       │       │   ├── [       2035]  TransducerGraph$SetToStringNodeProcessor.class
    │       │   │       │       │   └── [      22093]  TransducerGraph.class
    │       │   │       │       ├── [       4096]  graph
    │       │   │       │       │   ├── [       2776]  ConnectedComponents.class
    │       │   │       │       │   ├── [       3018]  DijkstraShortestPath.class
    │       │   │       │       │   ├── [       1129]  DirectedMultiGraph$1.class
    │       │   │       │       │   ├── [       1129]  DirectedMultiGraph$2.class
    │       │   │       │       │   ├── [        938]  DirectedMultiGraph$3.class
    │       │   │       │       │   ├── [       2950]  DirectedMultiGraph$EdgeIterator.class
    │       │   │       │       │   ├── [      14351]  DirectedMultiGraph.class
    │       │   │       │       │   └── [       1679]  Graph.class
    │       │   │       │       ├── [       4096]  ie
    │       │   │       │       │   ├── [       2849]  AbstractSequenceClassifier$1.class
    │       │   │       │       │   ├── [      43711]  AbstractSequenceClassifier.class
    │       │   │       │       │   ├── [       8136]  AcquisitionsPrior.class
    │       │   │       │       │   ├── [      11506]  ClassifierCombiner.class
    │       │   │       │       │   ├── [       4096]  crf
    │       │   │       │       │   │   ├── [       1701]  CRFBiasedClassifier$CRFBiasedClassifierOptimizer.class
    │       │   │       │       │   │   ├── [       9215]  CRFBiasedClassifier.class
    │       │   │       │       │   │   ├── [       2152]  CRFClassifier$TestSequenceModel.class
    │       │   │       │       │   │   ├── [      67146]  CRFClassifier.class
    │       │   │       │       │   │   ├── [       5496]  CRFClassifierEvaluator.class
    │       │   │       │       │   │   ├── [      15651]  CRFCliqueTree.class
    │       │   │       │       │   │   ├── [       2317]  CRFDatum.class
    │       │   │       │       │   │   ├── [       7005]  CRFFeatureExporter.class
    │       │   │       │       │   │   ├── [       2465]  CRFLabel.class
    │       │   │       │       │   │   ├── [      14416]  CRFLogConditionalObjectiveFloatFunction.class
    │       │   │       │       │   │   ├── [      13869]  CRFLogConditionalObjectiveFunction.class
    │       │   │       │       │   │   ├── [      12612]  FactorTable.class
    │       │   │       │       │   │   └── [       8548]  FloatFactorTable.class
    │       │   │       │       │   ├── [       5669]  EmpiricalNERPrior.class
    │       │   │       │       │   ├── [      12070]  EntityCachingAbstractSequencePrior.class
    │       │   │       │       │   ├── [       1550]  Entity.class
    │       │   │       │       │   ├── [       4096]  machinereading
    │       │   │       │       │   │   ├── [       4096]  common
    │       │   │       │       │   │   │   ├── [       4166]  DomReader.class
    │       │   │       │       │   │   │   ├── [       1077]  NoPunctuationHeadFinder$1.class
    │       │   │       │       │   │   │   ├── [       2025]  NoPunctuationHeadFinder.class
    │       │   │       │       │   │   │   ├── [       3571]  SimpleTokenize.class
    │       │   │       │       │   │   │   ├── [        767]  StringDictionary$IndexAndCount.class
    │       │   │       │       │   │   │   └── [       5832]  StringDictionary.class
    │       │   │       │       │   │   ├── [       4096]  domains
    │       │   │       │       │   │   │   └── [       4096]  ace
    │       │   │       │       │   │   │       ├── [      23471]  AceReader.class
    │       │   │       │       │   │   │       └── [       4096]  reader
    │       │   │       │       │   │   │           ├── [       3709]  AceCharSeq.class
    │       │   │       │       │   │   │           ├── [      26338]  AceDocument.class
    │       │   │       │       │   │   │           ├── [      10590]  AceDomReader.class
    │       │   │       │       │   │   │           ├── [        890]  AceElement.class
    │       │   │       │       │   │   │           ├── [       3371]  AceEntity.class
    │       │   │       │       │   │   │           ├── [       6900]  AceEntityMention.class
    │       │   │       │       │   │   │           ├── [       3016]  AceEvent.class
    │       │   │       │       │   │   │           ├── [        814]  AceEventMentionArgument.class
    │       │   │       │       │   │   │           ├── [       5065]  AceEventMention.class
    │       │   │       │       │   │   │           ├── [       2617]  AceMentionArgument.class
    │       │   │       │       │   │   │           ├── [        949]  AceMention.class
    │       │   │       │       │   │   │           ├── [       3901]  AceRelation.class
    │       │   │       │       │   │   │           ├── [        826]  AceRelationMentionArgument.class
    │       │   │       │       │   │   │           ├── [       5104]  AceRelationMention.class
    │       │   │       │       │   │   │           ├── [       5320]  AceSentenceSegmenter.class
    │       │   │       │       │   │   │           ├── [      11222]  AceToken.class
    │       │   │       │       │   │   │           ├── [        503]  MatchException.class
    │       │   │       │       │   │   │           ├── [      11050]  RobustTokenizer$AbbreviationMap.class
    │       │   │       │       │   │   │           ├── [       2011]  RobustTokenizer$WordToken.class
    │       │   │       │       │   │   │           └── [      18227]  RobustTokenizer.class
    │       │   │       │       │   │   ├── [      17237]  GenericDataSetReader.class
    │       │   │       │       │   │   ├── [       2084]  RelationMentionFactory.class
    │       │   │       │       │   │   └── [       4096]  structure
    │       │   │       │       │   │       ├── [      20530]  AnnotationUtils.class
    │       │   │       │       │   │       ├── [       1211]  EntityMention$CompByHead.class
    │       │   │       │       │   │       ├── [       8282]  EntityMention.class
    │       │   │       │       │   │       ├── [       9671]  EventMention.class
    │       │   │       │       │   │       ├── [       1245]  ExtractionObject$CompByExtent.class
    │       │   │       │       │   │       ├── [       9345]  ExtractionObject.class
    │       │   │       │       │   │       ├── [       1039]  MachineReadingAnnotations$DependencyAnnotation.class
    │       │   │       │       │   │       ├── [        889]  MachineReadingAnnotations$DocumentDirectoryAnnotation.class
    │       │   │       │       │   │       ├── [        927]  MachineReadingAnnotations$DocumentIdAnnotation.class
    │       │   │       │       │   │       ├── [       1132]  MachineReadingAnnotations$EntityMentionsAnnotation.class
    │       │   │       │       │   │       ├── [       1127]  MachineReadingAnnotations$EventMentionsAnnotation.class
    │       │   │       │       │   │       ├── [        856]  MachineReadingAnnotations$GenderAnnotation.class
    │       │   │       │       │   │       ├── [       1142]  MachineReadingAnnotations$RelationMentionsAnnotation.class
    │       │   │       │       │   │       ├── [        859]  MachineReadingAnnotations$TriggerAnnotation.class
    │       │   │       │       │   │       ├── [       1463]  MachineReadingAnnotations.class
    │       │   │       │       │   │       ├── [      13046]  RelationMention.class
    │       │   │       │       │   │       └── [       3197]  Span.class
    │       │   │       │       │   ├── [       4096]  ner
    │       │   │       │       │   │   ├── [       5924]  CMMClassifier$Scorer.class
    │       │   │       │       │   │   └── [      43471]  CMMClassifier.class
    │       │   │       │       │   ├── [       7154]  NERClassifierCombiner.class
    │       │   │       │       │   ├── [        743]  NERFeatureFactory$Bin1Annotation.class
    │       │   │       │       │   ├── [        743]  NERFeatureFactory$Bin2Annotation.class
    │       │   │       │       │   ├── [        743]  NERFeatureFactory$Bin3Annotation.class
    │       │   │       │       │   ├── [        743]  NERFeatureFactory$Bin4Annotation.class
    │       │   │       │       │   ├── [        743]  NERFeatureFactory$Bin5Annotation.class
    │       │   │       │       │   ├── [        743]  NERFeatureFactory$Bin6Annotation.class
    │       │   │       │       │   ├── [        868]  NERFeatureFactory$GazetteInfo.class
    │       │   │       │       │   ├── [      52135]  NERFeatureFactory.class
    │       │   │       │       │   ├── [       1893]  NumberNormalizer$1.class
    │       │   │       │       │   ├── [       1917]  NumberNormalizer$2.class
    │       │   │       │       │   ├── [      21915]  NumberNormalizer.class
    │       │   │       │       │   ├── [       4096]  pascal
    │       │   │       │       │   │   ├── [       1008]  AcronymModel$AfterAligned.class
    │       │   │       │       │   │   ├── [       1288]  AcronymModel$AlignedPerWord.class
    │       │   │       │       │   │   ├── [       1204]  AcronymModel$BegWord.class
    │       │   │       │       │   │   ├── [       1211]  AcronymModel$EndWord.class
    │       │   │       │       │   │   ├── [        328]  AcronymModel$Feature.class
    │       │   │       │       │   │   ├── [       1335]  AcronymModel$LettersAligned.class
    │       │   │       │       │   │   ├── [        833]  AcronymModel$RunningAverage.class
    │       │   │       │       │   │   ├── [       1513]  AcronymModel$SyllableBoundary.class
    │       │   │       │       │   │   ├── [       1839]  AcronymModel$WordsSkipped.class
    │       │   │       │       │   │   ├── [      11974]  AcronymModel.class
    │       │   │       │       │   │   ├── [       3404]  Alignment.class
    │       │   │       │       │   │   ├── [       4794]  AlignmentFactory.class
    │       │   │       │       │   │   ├── [        869]  CliqueTemplates.class
    │       │   │       │       │   │   ├── [       1556]  DateTemplate.class
    │       │   │       │       │   │   ├── [      27713]  DefaultTeXHyphenData.class
    │       │   │       │       │   │   ├── [       2176]  InfoTemplate.class
    │       │   │       │       │   │   ├── [       1295]  ISODateInstance$DateField.class
    │       │   │       │       │   │   ├── [      22453]  ISODateInstance.class
    │       │   │       │       │   │   ├── [       7878]  PascalTemplate.class
    │       │   │       │       │   │   ├── [       2582]  Prior.class
    │       │   │       │       │   │   ├── [        209]  RelationalModel.class
    │       │   │       │       │   │   ├── [        661]  TeXHyphenator$Node.class
    │       │   │       │       │   │   └── [      33005]  TeXHyphenator.class
    │       │   │       │       │   ├── [      34064]  QuantifiableEntityNormalizer.class
    │       │   │       │       │   ├── [       4096]  regexp
    │       │   │       │       │   │   ├── [      22851]  NumberSequenceClassifier.class
    │       │   │       │       │   │   ├── [       1644]  RegexNERSequenceClassifier$Entry.class
    │       │   │       │       │   │   └── [      10180]  RegexNERSequenceClassifier.class
    │       │   │       │       │   ├── [       7405]  SeminarsPrior.class
    │       │   │       │       │   └── [       2631]  UniformPrior.class
    │       │   │       │       ├── [       4096]  international
    │       │   │       │       │   ├── [       4096]  arabic
    │       │   │       │       │   │   ├── [       3276]  ArabicMorphoFeatureSpecification$ArabicMorphoFeatures.class
    │       │   │       │       │   │   ├── [       8123]  ArabicMorphoFeatureSpecification.class
    │       │   │       │       │   │   └── [       4096]  process
    │       │   │       │       │   │       ├── [      22553]  ArabicLexer.class
    │       │   │       │       │   │       ├── [       2772]  ArabicTokenizer$ArabicTokenizerFactory.class
    │       │   │       │       │   │       └── [       6192]  ArabicTokenizer.class
    │       │   │       │       │   ├── [       4096]  french
    │       │   │       │       │   │   ├── [       6067]  FrenchMorphoFeatureSpecification.class
    │       │   │       │       │   │   └── [       3887]  FrenchUnknownWordSignatures.class
    │       │   │       │       │   ├── [       1420]  Languages$Language.class
    │       │   │       │       │   ├── [       2916]  Languages.class
    │       │   │       │       │   └── [       4096]  morph
    │       │   │       │       │       ├── [       5272]  MorphoFeatures.class
    │       │   │       │       │       ├── [       1890]  MorphoFeatureSpecification$MorphoFeatureType.class
    │       │   │       │       │       └── [       1885]  MorphoFeatureSpecification.class
    │       │   │       │       ├── [       4096]  io
    │       │   │       │       │   ├── [       2850]  BZip2PipedOutputStream.class
    │       │   │       │       │   ├── [       1472]  EncodingFileReader.class
    │       │   │       │       │   ├── [       2223]  EncodingFileWriter.class
    │       │   │       │       │   ├── [       2010]  EncodingPrintWriter$err.class
    │       │   │       │       │   ├── [       2026]  EncodingPrintWriter$out.class
    │       │   │       │       │   ├── [       1400]  EncodingPrintWriter.class
    │       │   │       │       │   ├── [       1590]  ExtensionFileFilter.class
    │       │   │       │       │   ├── [       3670]  FileSequentialCollection$FileSequentialCollectionIterator.class
    │       │   │       │       │   ├── [       4788]  FileSequentialCollection.class
    │       │   │       │       │   ├── [        962]  InDataStreamFile.class
    │       │   │       │       │   ├── [       2608]  IOUtils$1$1.class
    │       │   │       │       │   ├── [       1011]  IOUtils$1.class
    │       │   │       │       │   ├── [       2163]  IOUtils$2$1.class
    │       │   │       │       │   ├── [       1028]  IOUtils$2.class
    │       │   │       │       │   ├── [      25110]  IOUtils.class
    │       │   │       │       │   ├── [        396]  Lexer.class
    │       │   │       │       │   ├── [       1375]  NumberRangeFileFilter.class
    │       │   │       │       │   ├── [       4053]  NumberRangesFileFilter.class
    │       │   │       │       │   ├── [        728]  OutDataStreamFile.class
    │       │   │       │       │   ├── [        728]  PrintFile.class
    │       │   │       │       │   ├── [       2743]  ReaderInputStream.class
    │       │   │       │       │   ├── [        856]  RegExFileFilter.class
    │       │   │       │       │   ├── [        825]  RuntimeIOException.class
    │       │   │       │       │   └── [        788]  StringOutputStream.class
    │       │   │       │       ├── [      20480]  ling
    │       │   │       │       │   ├── [       1104]  AnnotationLookup$KeyLookup$1.class
    │       │   │       │       │   ├── [      10808]  AnnotationLookup$KeyLookup.class
    │       │   │       │       │   ├── [       2421]  AnnotationLookup$OldFeatureLabelKeys.class
    │       │   │       │       │   ├── [       2314]  AnnotationLookup.class
    │       │   │       │       │   ├── [       3723]  BasicDatum.class
    │       │   │       │       │   ├── [      13211]  BasicDocument.class
    │       │   │       │       │   ├── [        738]  CategoryWordTag$LabelFactoryHolder.class
    │       │   │       │       │   ├── [       3220]  CategoryWordTag.class
    │       │   │       │       │   ├── [       1480]  CategoryWordTagFactory.class
    │       │   │       │       │   ├── [        465]  CoreAnnotation.class
    │       │   │       │       │   ├── [        741]  CoreAnnotations$AbbrAnnotation.class
    │       │   │       │       │   ├── [        747]  CoreAnnotations$AbgeneAnnotation.class
    │       │   │       │       │   ├── [        744]  CoreAnnotations$AbstrAnnotation.class
    │       │   │       │       │   ├── [        744]  CoreAnnotations$AfterAnnotation.class
    │       │   │       │       │   ├── [        747]  CoreAnnotations$AnswerAnnotation.class
    │       │   │       │       │   ├── [        743]  CoreAnnotations$AnswerObjectAnnotation.class
    │       │   │       │       │   ├── [        759]  CoreAnnotations$AntecedentAnnotation.class
    │       │   │       │       │   ├── [       1008]  CoreAnnotations$ArgDescendentAnnotation.class
    │       │   │       │       │   ├── [        753]  CoreAnnotations$ArgumentAnnotation.class
    │       │   │       │       │   ├── [        889]  CoreAnnotations$BagOfWordsAnnotation.class
    │       │   │       │       │   ├── [        738]  CoreAnnotations$BeAnnotation.class
    │       │   │       │       │   ├── [        747]  CoreAnnotations$BeforeAnnotation.class
    │       │   │       │       │   ├── [        762]  CoreAnnotations$BeginIndexAnnotation.class
    │       │   │       │       │   ├── [        762]  CoreAnnotations$BestCliquesAnnotation.class
    │       │   │       │       │   ├── [        753]  CoreAnnotations$BestFullAnnotation.class
    │       │   │       │       │   ├── [        759]  CoreAnnotations$CalendarAnnotation.class
    │       │   │       │       │   ├── [        753]  CoreAnnotations$CategoryAnnotation.class
    │       │   │       │       │   ├── [        792]  CoreAnnotations$CategoryFunctionalTagAnnotation.class
    │       │   │       │       │   ├── [        792]  CoreAnnotations$CharacterOffsetBeginAnnotation.class
    │       │   │       │       │   ├── [        786]  CoreAnnotations$CharacterOffsetEndAnnotation.class
    │       │   │       │       │   ├── [        741]  CoreAnnotations$CharAnnotation.class
    │       │   │       │       │   ├── [        762]  CoreAnnotations$ChineseCharAnnotation.class
    │       │   │       │       │   ├── [        786]  CoreAnnotations$ChineseIsSegmentedAnnotation.class
    │       │   │       │       │   ├── [        771]  CoreAnnotations$ChineseOrigSegAnnotation.class
    │       │   │       │       │   ├── [        759]  CoreAnnotations$ChineseSegAnnotation.class
    │       │   │       │       │   ├── [        744]  CoreAnnotations$ChunkAnnotation.class
    │       │   │       │       │   ├── [        756]  CoreAnnotations$CoarseTagAnnotation.class
    │       │   │       │       │   ├── [        762]  CoreAnnotations$CommonWordsAnnotation.class
    │       │   │       │       │   ├── [        792]  CoreAnnotations$CoNLLDepAnnotation.class
    │       │   │       │       │   ├── [        789]  CoreAnnotations$CoNLLDepParentIndexAnnotation.class
    │       │   │       │       │   ├── [        765]  CoreAnnotations$CoNLLDepTypeAnnotation.class
    │       │   │       │       │   ├── [        774]  CoreAnnotations$CoNLLPredicateAnnotation.class
    │       │   │       │       │   ├── [        744]  CoreAnnotations$CoNLLSRLAnnotation.class
    │       │   │       │       │   ├── [        883]  CoreAnnotations$ContextsAnnotation.class
    │       │   │       │       │   ├── [        744]  CoreAnnotations$CopyAnnotation.class
    │       │   │       │       │   ├── [        780]  CoreAnnotations$CostMagnificationAnnotation.class
    │       │   │       │       │   ├── [        813]  CoreAnnotations$CovertIDAnnotation.class
    │       │   │       │       │   ├── [        756]  CoreAnnotations$D2_LBeginAnnotation.class
    │       │   │       │       │   ├── [        750]  CoreAnnotations$D2_LEndAnnotation.class
    │       │   │       │       │   ├── [        759]  CoreAnnotations$D2_LMiddleAnnotation.class
    │       │   │       │       │   ├── [        738]  CoreAnnotations$DayAnnotation.class
    │       │   │       │       │   ├── [       1025]  CoreAnnotations$DependentsAnnotation.class
    │       │   │       │       │   ├── [        741]  CoreAnnotations$DictAnnotation.class
    │       │   │       │       │   ├── [        750]  CoreAnnotations$DistSimAnnotation.class
    │       │   │       │       │   ├── [        738]  CoreAnnotations$DoAnnotation.class
    │       │   │       │       │   ├── [        750]  CoreAnnotations$DocDateAnnotation.class
    │       │   │       │       │   ├── [        744]  CoreAnnotations$DocIDAnnotation.class
    │       │   │       │       │   ├── [        747]  CoreAnnotations$DomainAnnotation.class
    │       │   │       │       │   ├── [        756]  CoreAnnotations$EndIndexAnnotation.class
    │       │   │       │       │   ├── [        762]  CoreAnnotations$EntityClassAnnotation.class
    │       │   │       │       │   ├── [        759]  CoreAnnotations$EntityRuleAnnotation.class
    │       │   │       │       │   ├── [        759]  CoreAnnotations$EntityTypeAnnotation.class
    │       │   │       │       │   ├── [        753]  CoreAnnotations$FeaturesAnnotation.class
    │       │   │       │       │   ├── [        756]  CoreAnnotations$FemaleGazAnnotation.class
    │       │   │       │       │   ├── [        759]  CoreAnnotations$FirstChildAnnotation.class
    │       │   │       │       │   ├── [        783]  CoreAnnotations$ForcedSentenceEndAnnotation.class
    │       │   │       │       │   ├── [        741]  CoreAnnotations$FreqAnnotation.class
    │       │   │       │       │   ├── [        738]  CoreAnnotations$GazAnnotation.class
    │       │   │       │       │   ├── [        790]  CoreAnnotations$GazetteerAnnotation.class
    │       │   │       │       │   ├── [        962]  CoreAnnotations$GenericTokensAnnotation.class
    │       │   │       │       │   ├── [        744]  CoreAnnotations$GeniaAnnotation.class
    │       │   │       │       │   ├── [        759]  CoreAnnotations$GoldAnswerAnnotation.class
    │       │   │       │       │   ├── [        753]  CoreAnnotations$GovernorAnnotation.class
    │       │   │       │       │   ├── [        762]  CoreAnnotations$GrandparentAnnotation.class
    │       │   │       │       │   ├── [        744]  CoreAnnotations$HaveAnnotation.class
    │       │   │       │       │   ├── [        771]  CoreAnnotations$HeadWordStringAnnotation.class
    │       │   │       │       │   ├── [        747]  CoreAnnotations$HeightAnnotation.class
    │       │   │       │       │   ├── [        735]  CoreAnnotations$IDAnnotation.class
    │       │   │       │       │   ├── [        738]  CoreAnnotations$IDFAnnotation.class
    │       │   │       │       │   ├── [        735]  CoreAnnotations$INAnnotation.class
    │       │   │       │       │   ├── [        747]  CoreAnnotations$IndexAnnotation.class
    │       │   │       │       │   ├── [        771]  CoreAnnotations$InterpretationAnnotation.class
    │       │   │       │       │   ├── [        762]  CoreAnnotations$IsDateRangeAnnotation.class
    │       │   │       │       │   ├── [        744]  CoreAnnotations$IsURLAnnotation.class
    │       │   │       │       │   ├── [        744]  CoreAnnotations$LabelAnnotation.class
    │       │   │       │       │   ├── [        762]  CoreAnnotations$LabelWeightAnnotation.class
    │       │   │       │       │   ├── [        750]  CoreAnnotations$LastGazAnnotation.class
    │       │   │       │       │   ├── [        759]  CoreAnnotations$LastTaggedAnnotation.class
    │       │   │       │       │   ├── [        747]  CoreAnnotations$LBeginAnnotation.class
    │       │   │       │       │   ├── [       1086]  CoreAnnotations$LeftChildrenNodeAnnotation.class
    │       │   │       │       │   ├── [        756]  CoreAnnotations$LeftTermAnnotation.class
    │       │   │       │       │   ├── [        744]  CoreAnnotations$LemmaAnnotation.class
    │       │   │       │       │   ├── [        741]  CoreAnnotations$LEndAnnotation.class
    │       │   │       │       │   ├── [        747]  CoreAnnotations$LengthAnnotation.class
    │       │   │       │       │   ├── [        750]  CoreAnnotations$LMiddleAnnotation.class
    │       │   │       │       │   ├── [        750]  CoreAnnotations$MaleGazAnnotation.class
    │       │   │       │       │   ├── [        750]  CoreAnnotations$MarkingAnnotation.class
    │       │   │       │       │   ├── [        744]  CoreAnnotations$MonthAnnotation.class
    │       │   │       │       │   ├── [        759]  CoreAnnotations$MorphoCaseAnnotation.class
    │       │   │       │       │   ├── [        756]  CoreAnnotations$MorphoGenAnnotation.class
    │       │   │       │       │   ├── [        756]  CoreAnnotations$MorphoNumAnnotation.class
    │       │   │       │       │   ├── [        759]  CoreAnnotations$MorphoPersAnnotation.class
    │       │   │       │       │   ├── [        771]  CoreAnnotations$NamedEntityTagAnnotation.class
    │       │   │       │       │   ├── [        922]  CoreAnnotations$NeighborsAnnotation.class
    │       │   │       │       │   ├── [        744]  CoreAnnotations$NERIDAnnotation.class
    │       │   │       │       │   ├── [        801]  CoreAnnotations$NormalizedNamedEntityTagAnnotation.class
    │       │   │       │       │   ├── [        741]  CoreAnnotations$NotAnnotation.class
    │       │   │       │       │   ├── [        773]  CoreAnnotations$NumericCompositeObjectAnnotation.class
    │       │   │       │       │   ├── [        789]  CoreAnnotations$NumericCompositeTypeAnnotation.class
    │       │   │       │       │   ├── [        792]  CoreAnnotations$NumericCompositeValueAnnotation.class
    │       │   │       │       │   ├── [        746]  CoreAnnotations$NumericObjectAnnotation.class
    │       │   │       │       │   ├── [        762]  CoreAnnotations$NumericTypeAnnotation.class
    │       │   │       │       │   ├── [        765]  CoreAnnotations$NumericValueAnnotation.class
    │       │   │       │       │   ├── [        834]  CoreAnnotations$NumerizedTokensAnnotation.class
    │       │   │       │       │   ├── [        777]  CoreAnnotations$NumTxtSentencesAnnotation.class
    │       │   │       │       │   ├── [        771]  CoreAnnotations$OriginalAnswerAnnotation.class
    │       │   │       │       │   ├── [        765]  CoreAnnotations$OriginalCharAnnotation.class
    │       │   │       │       │   ├── [        765]  CoreAnnotations$OriginalTextAnnotation.class
    │       │   │       │       │   ├── [        759]  CoreAnnotations$ParagraphAnnotation.class
    │       │   │       │       │   ├── [        953]  CoreAnnotations$ParagraphsAnnotation.class
    │       │   │       │       │   ├── [        765]  CoreAnnotations$ParaPositionAnnotation.class
    │       │   │       │       │   ├── [        747]  CoreAnnotations$ParentAnnotation.class
    │       │   │       │       │   ├── [        765]  CoreAnnotations$PartOfSpeechAnnotation.class
    │       │   │       │       │   ├── [        753]  CoreAnnotations$PercentAnnotation.class
    │       │   │       │       │   ├── [        796]  CoreAnnotations$PhraseWordsAnnotation.class
    │       │   │       │       │   ├── [        771]  CoreAnnotations$PhraseWordsTagAnnotation.class
    │       │   │       │       │   ├── [        753]  CoreAnnotations$PolarityAnnotation.class
    │       │   │       │       │   ├── [        753]  CoreAnnotations$PositionAnnotation.class
    │       │   │       │       │   ├── [        774]  CoreAnnotations$PossibleAnswersAnnotation.class
    │       │   │       │       │   ├── [        774]  CoreAnnotations$PredictedAnswerAnnotation.class
    │       │   │       │       │   ├── [        756]  CoreAnnotations$PrevChildAnnotation.class
    │       │   │       │       │   ├── [        811]  CoreAnnotations$PriorAnnotation.class
    │       │   │       │       │   ├── [        780]  CoreAnnotations$ProjectedCategoryAnnotation.class
    │       │   │       │       │   ├── [        744]  CoreAnnotations$ProtoAnnotation.class
    │       │   │       │       │   ├── [        741]  CoreAnnotations$RoleAnnotation.class
    │       │   │       │       │   ├── [        750]  CoreAnnotations$SectionAnnotation.class
    │       │   │       │       │   ├── [        774]  CoreAnnotations$SemanticHeadTagAnnotation.class
    │       │   │       │       │   ├── [        777]  CoreAnnotations$SemanticHeadWordAnnotation.class
    │       │   │       │       │   ├── [        762]  CoreAnnotations$SemanticTagAnnotation.class
    │       │   │       │       │   ├── [        765]  CoreAnnotations$SemanticWordAnnotation.class
    │       │   │       │       │   ├── [        759]  CoreAnnotations$SentenceIDAnnotation.class
    │       │   │       │       │   ├── [        771]  CoreAnnotations$SentenceIndexAnnotation.class
    │       │   │       │       │   ├── [        777]  CoreAnnotations$SentencePositionAnnotation.class
    │       │   │       │       │   ├── [        950]  CoreAnnotations$SentencesAnnotation.class
    │       │   │       │       │   ├── [        744]  CoreAnnotations$ShapeAnnotation.class
    │       │   │       │       │   ├── [        762]  CoreAnnotations$SpaceBeforeAnnotation.class
    │       │   │       │       │   ├── [        780]  CoreAnnotations$SpanAnnotation.class
    │       │   │       │       │   ├── [        750]  CoreAnnotations$SpeakerAnnotation.class
    │       │   │       │       │   ├── [        845]  CoreAnnotations$SRLIDAnnotation.class
    │       │   │       │       │   ├── [       1284]  CoreAnnotations$SRL_ID.class
    │       │   │       │       │   ├── [        951]  CoreAnnotations$SRLInstancesAnnotation.class
    │       │   │       │       │   ├── [        792]  CoreAnnotations$StackedNamedEntityTagAnnotation.class
    │       │   │       │       │   ├── [        789]  CoreAnnotations$StateAnnotation.class
    │       │   │       │       │   ├── [        741]  CoreAnnotations$StemAnnotation.class
    │       │   │       │       │   ├── [        780]  CoreAnnotations$SubcategorizationAnnotation.class
    │       │   │       │       │   ├── [        786]  CoreAnnotations$TagLabelAnnotation.class
    │       │   │       │       │   ├── [        741]  CoreAnnotations$TextAnnotation.class
    │       │   │       │       │   ├── [        762]  CoreAnnotations$TokenBeginAnnotation.class
    │       │   │       │       │   ├── [        756]  CoreAnnotations$TokenEndAnnotation.class
    │       │   │       │       │   ├── [        945]  CoreAnnotations$TokensAnnotation.class
    │       │   │       │       │   ├── [        744]  CoreAnnotations$TopicAnnotation.class
    │       │   │       │       │   ├── [        753]  CoreAnnotations$TrueCaseAnnotation.class
    │       │   │       │       │   ├── [        765]  CoreAnnotations$TrueCaseTextAnnotation.class
    │       │   │       │       │   ├── [        750]  CoreAnnotations$TrueTagAnnotation.class
    │       │   │       │       │   ├── [        747]  CoreAnnotations$UBlockAnnotation.class
    │       │   │       │       │   ├── [        747]  CoreAnnotations$UnaryAnnotation.class
    │       │   │       │       │   ├── [        750]  CoreAnnotations$UnknownAnnotation.class
    │       │   │       │       │   ├── [        759]  CoreAnnotations$UtteranceAnnotation.class
    │       │   │       │       │   ├── [        747]  CoreAnnotations$UTypeAnnotation.class
    │       │   │       │       │   ├── [        744]  CoreAnnotations$ValueAnnotation.class
    │       │   │       │       │   ├── [        756]  CoreAnnotations$VerbSenseAnnotation.class
    │       │   │       │       │   ├── [        738]  CoreAnnotations$WebAnnotation.class
    │       │   │       │       │   ├── [        753]  CoreAnnotations$WordFormAnnotation.class
    │       │   │       │       │   ├── [        759]  CoreAnnotations$WordnetSynAnnotation.class
    │       │   │       │       │   ├── [        765]  CoreAnnotations$WordPositionAnnotation.class
    │       │   │       │       │   ├── [        756]  CoreAnnotations$WordSenseAnnotation.class
    │       │   │       │       │   ├── [        927]  CoreAnnotations$XmlContextAnnotation.class
    │       │   │       │       │   ├── [        759]  CoreAnnotations$XmlElementAnnotation.class
    │       │   │       │       │   ├── [        741]  CoreAnnotations$YearAnnotation.class
    │       │   │       │       │   ├── [      16136]  CoreAnnotations.class
    │       │   │       │       │   ├── [       2286]  CoreLabel$CoreLabelFactory.class
    │       │   │       │       │   ├── [        377]  CoreLabel$GenericAnnotation.class
    │       │   │       │       │   ├── [       9973]  CoreLabel.class
    │       │   │       │       │   ├── [       1078]  CyclicCoreLabel$1.class
    │       │   │       │       │   ├── [       1461]  CyclicCoreLabel$2.class
    │       │   │       │       │   ├── [       5672]  CyclicCoreLabel.class
    │       │   │       │       │   ├── [        402]  Datum.class
    │       │   │       │       │   ├── [        519]  Document.class
    │       │   │       │       │   ├── [       4858]  DocumentReader.class
    │       │   │       │       │   ├── [        278]  Featurizable.class
    │       │   │       │       │   ├── [        213]  HasCategory.class
    │       │   │       │       │   ├── [        291]  HasContext.class
    │       │   │       │       │   ├── [        292]  HasIndex.class
    │       │   │       │       │   ├── [        260]  HasOffset.class
    │       │   │       │       │   ├── [        193]  HasTag.class
    │       │   │       │       │   ├── [        225]  HasWord.class
    │       │   │       │       │   ├── [       1441]  IndexedWord$1.class
    │       │   │       │       │   ├── [       5777]  IndexedWord.class
    │       │   │       │       │   ├── [        302]  Label.class
    │       │   │       │       │   ├── [        319]  Labeled.class
    │       │   │       │       │   ├── [        717]  LabeledWord$LabelFactoryHolder.class
    │       │   │       │       │   ├── [       1961]  LabeledWord.class
    │       │   │       │       │   ├── [        359]  LabelFactory.class
    │       │   │       │       │   ├── [       3779]  RVFDatum.class
    │       │   │       │       │   ├── [       6643]  Sentence.class
    │       │   │       │       │   ├── [        634]  StringLabel$StringLabelFactoryHolder.class
    │       │   │       │       │   ├── [       2270]  StringLabel.class
    │       │   │       │       │   ├── [       1082]  StringLabelFactory.class
    │       │   │       │       │   ├── [        703]  Tag$LabelFactoryHolder.class
    │       │   │       │       │   ├── [       1094]  Tag$TagFactory.class
    │       │   │       │       │   ├── [       1265]  Tag.class
    │       │   │       │       │   ├── [        713]  TaggedWord$LabelFactoryHolder.class
    │       │   │       │       │   ├── [       2569]  TaggedWord.class
    │       │   │       │       │   ├── [       1583]  TaggedWordFactory.class
    │       │   │       │       │   ├── [      12288]  tokensregex
    │       │   │       │       │   │   ├── [       1206]  BasicSequenceMatchResult$MatchedGroup.class
    │       │   │       │       │   │   ├── [       6133]  BasicSequenceMatchResult.class
    │       │   │       │       │   │   ├── [      12049]  CoreMapExpressionExtractor.class
    │       │   │       │       │   │   ├── [       2118]  CoreMapNodePattern$AttributesEqualMatchChecker.class
    │       │   │       │       │   │   ├── [        778]  CoreMapNodePattern$NilAnnotationPattern.class
    │       │   │       │       │   │   ├── [        787]  CoreMapNodePattern$NotNilAnnotationPattern.class
    │       │   │       │       │   │   ├── [        986]  CoreMapNodePattern$NumericAnnotationPattern$CmpType$1.class
    │       │   │       │       │   │   ├── [       1019]  CoreMapNodePattern$NumericAnnotationPattern$CmpType$2.class
    │       │   │       │       │   │   ├── [       1019]  CoreMapNodePattern$NumericAnnotationPattern$CmpType$3.class
    │       │   │       │       │   │   ├── [       1019]  CoreMapNodePattern$NumericAnnotationPattern$CmpType$4.class
    │       │   │       │       │   │   ├── [       1019]  CoreMapNodePattern$NumericAnnotationPattern$CmpType$5.class
    │       │   │       │       │   │   ├── [       1019]  CoreMapNodePattern$NumericAnnotationPattern$CmpType$6.class
    │       │   │       │       │   │   ├── [       2686]  CoreMapNodePattern$NumericAnnotationPattern$CmpType.class
    │       │   │       │       │   │   ├── [       1807]  CoreMapNodePattern$NumericAnnotationPattern.class
    │       │   │       │       │   │   ├── [       2676]  CoreMapNodePattern$SequenceRegexPattern.class
    │       │   │       │       │   │   ├── [       1304]  CoreMapNodePattern$StringAnnotationPattern.class
    │       │   │       │       │   │   ├── [       2020]  CoreMapNodePattern$StringAnnotationRegexPattern.class
    │       │   │       │       │   │   ├── [       9186]  CoreMapNodePattern.class
    │       │   │       │       │   │   ├── [       1971]  CoreMapSequenceMatchAction$AnnotateAction.class
    │       │   │       │       │   │   ├── [       4286]  CoreMapSequenceMatchAction$MergeAction.class
    │       │   │       │       │   │   ├── [       1106]  CoreMapSequenceMatchAction.class
    │       │   │       │       │   │   ├── [       1434]  CoreMapSequenceMatcher$1.class
    │       │   │       │       │   │   ├── [       1422]  CoreMapSequenceMatcher$BasicCoreMapSequenceMatcher.class
    │       │   │       │       │   │   ├── [       4455]  CoreMapSequenceMatcher.class
    │       │   │       │       │   │   ├── [       1662]  MatchedExpression$1.class
    │       │   │       │       │   │   ├── [       1310]  MatchedExpression$2.class
    │       │   │       │       │   │   ├── [       1372]  MatchedExpression$3.class
    │       │   │       │       │   │   ├── [       1370]  MatchedExpression$4.class
    │       │   │       │       │   │   ├── [       1700]  MatchedExpression$5.class
    │       │   │       │       │   │   ├── [       1394]  MatchedExpression$6.class
    │       │   │       │       │   │   ├── [       1795]  MatchedExpression$7.class
    │       │   │       │       │   │   ├── [       1621]  MatchedExpression$SingleAnnotationExtractor.class
    │       │   │       │       │   │   ├── [      12976]  MatchedExpression.class
    │       │   │       │       │   │   ├── [       2740]  MultiCoreMapNodePattern.class
    │       │   │       │       │   │   ├── [       2116]  MultiNodePattern$IntersectMultiNodePattern.class
    │       │   │       │       │   │   ├── [       2327]  MultiNodePattern$UnionMultiNodePattern.class
    │       │   │       │       │   │   ├── [       1430]  MultiNodePattern.class
    │       │   │       │       │   │   ├── [        831]  NodePattern$AnyNodePattern.class
    │       │   │       │       │   │   ├── [       1575]  NodePattern$ConjNodePattern.class
    │       │   │       │       │   │   ├── [       1575]  NodePattern$DisjNodePattern.class
    │       │   │       │       │   │   ├── [       1178]  NodePattern$NegateNodePattern.class
    │       │   │       │       │   │   ├── [       1383]  NodePattern.class
    │       │   │       │       │   │   ├── [       3788]  ParseException.class
    │       │   │       │       │   │   ├── [       1482]  SequenceMatchAction$BoundAction.class
    │       │   │       │       │   │   ├── [       2327]  SequenceMatchAction$BranchAction.class
    │       │   │       │       │   │   ├── [       1557]  SequenceMatchAction$NextMatchAction.class
    │       │   │       │       │   │   ├── [       2424]  SequenceMatchAction$SeriesAction.class
    │       │   │       │       │   │   ├── [       2110]  SequenceMatchAction$StartMatchAction.class
    │       │   │       │       │   │   ├── [        994]  SequenceMatchAction.class
    │       │   │       │       │   │   ├── [       4170]  SequenceMatcher$BranchState.class
    │       │   │       │       │   │   ├── [      14304]  SequenceMatcher$BranchStates.class
    │       │   │       │       │   │   ├── [       1305]  SequenceMatcher$FindType.class
    │       │   │       │       │   │   ├── [       1348]  SequenceMatcher$MatchedStates$1.class
    │       │   │       │       │   │   ├── [      11633]  SequenceMatcher$MatchedStates.class
    │       │   │       │       │   │   ├── [       1368]  SequenceMatcher$State.class
    │       │   │       │       │   │   ├── [      10923]  SequenceMatcher.class
    │       │   │       │       │   │   ├── [       1114]  SequenceMatchResult$1.class
    │       │   │       │       │   │   ├── [       1115]  SequenceMatchResult$2.class
    │       │   │       │       │   │   ├── [       1109]  SequenceMatchResult$3.class
    │       │   │       │       │   │   ├── [       1096]  SequenceMatchResult$4.class
    │       │   │       │       │   │   ├── [       1625]  SequenceMatchResult$GroupToIntervalFunc.class
    │       │   │       │       │   │   ├── [       2467]  SequenceMatchResult.class
    │       │   │       │       │   │   ├── [       1423]  SequenceMatchRules$AnnotationExtractRule.class
    │       │   │       │       │   │   ├── [        927]  SequenceMatchRules$AssignmentRule.class
    │       │   │       │       │   │   ├── [       7953]  SequenceMatchRules$CompositeValue.class
    │       │   │       │       │   │   ├── [       2118]  SequenceMatchRules$CoreMapExtractRule.class
    │       │   │       │       │   │   ├── [       1788]  SequenceMatchRules$CoreMapFunctionApplier.class
    │       │   │       │       │   │   ├── [        885]  SequenceMatchRules$Expression.class
    │       │   │       │       │   │   ├── [        445]  SequenceMatchRules$ExtractRule.class
    │       │   │       │       │   │   ├── [       2497]  SequenceMatchRules$FilterExtractRule.class
    │       │   │       │       │   │   ├── [       6857]  SequenceMatchRules$FunctionExpression.class
    │       │   │       │       │   │   ├── [       2964]  SequenceMatchRules$ListExtractRule.class
    │       │   │       │       │   │   ├── [       1117]  SequenceMatchRules$PrimitiveValue.class
    │       │   │       │       │   │   ├── [       3039]  SequenceMatchRules$RegexMatchVarValue.class
    │       │   │       │       │   │   ├── [       1323]  SequenceMatchRules$RegexValue.class
    │       │   │       │       │   │   ├── [        252]  SequenceMatchRules$Rule.class
    │       │   │       │       │   │   ├── [       2890]  SequenceMatchRules$SequenceMatchedExpressionExtractor.class
    │       │   │       │       │   │   ├── [       2402]  SequenceMatchRules$SequenceMatchResultExtractor.class
    │       │   │       │       │   │   ├── [       3780]  SequenceMatchRules$SequencePatternExtractRule.class
    │       │   │       │       │   │   ├── [       2490]  SequenceMatchRules$StringMatchedExpressionExtractor.class
    │       │   │       │       │   │   ├── [       1940]  SequenceMatchRules$StringMatchResultExtractor.class
    │       │   │       │       │   │   ├── [       4262]  SequenceMatchRules$StringPatternExtractRule.class
    │       │   │       │       │   │   ├── [       3526]  SequenceMatchRules$Value.class
    │       │   │       │       │   │   ├── [        601]  SequenceMatchRules$ValueFunction.class
    │       │   │       │       │   │   ├── [       1698]  SequenceMatchRules$VarValue.class
    │       │   │       │       │   │   ├── [      10742]  SequenceMatchRules.class
    │       │   │       │       │   │   ├── [        901]  SequencePattern$1.class
    │       │   │       │       │   │   ├── [       3837]  SequencePattern$AndPatternExpr.class
    │       │   │       │       │   │   ├── [       2510]  SequencePattern$BackRefPatternExpr.class
    │       │   │       │       │   │   ├── [       4245]  SequencePattern$BackRefState.class
    │       │   │       │       │   │   ├── [       2566]  SequencePattern$ConjEndState.class
    │       │   │       │       │   │   ├── [       3754]  SequencePattern$ConjMatchStateInfo.class
    │       │   │       │       │   │   ├── [       2386]  SequencePattern$ConjStartState.class
    │       │   │       │       │   │   ├── [       7940]  SequencePattern$Env.class
    │       │   │       │       │   │   ├── [       2684]  SequencePattern$Frag.class
    │       │   │       │       │   │   ├── [       1417]  SequencePattern$GroupEndState.class
    │       │   │       │       │   │   ├── [       3198]  SequencePattern$GroupPatternExpr.class
    │       │   │       │       │   │   ├── [       1642]  SequencePattern$GroupStartState.class
    │       │   │       │       │   │   ├── [       1338]  SequencePattern$MatchState.class
    │       │   │       │       │   │   ├── [       2049]  SequencePattern$MultiNodePatternExpr.class
    │       │   │       │       │   │   ├── [       3495]  SequencePattern$MultiNodePatternState.class
    │       │   │       │       │   │   ├── [       1995]  SequencePattern$NodePatternExpr.class
    │       │   │       │       │   │   ├── [       1892]  SequencePattern$NodePatternState.class
    │       │   │       │       │   │   ├── [        412]  SequencePattern$NodesMatchChecker.class
    │       │   │       │       │   │   ├── [       3355]  SequencePattern$OrPatternExpr.class
    │       │   │       │       │   │   ├── [       1104]  SequencePattern$Parser.class
    │       │   │       │       │   │   ├── [        927]  SequencePattern$PatternExpr.class
    │       │   │       │       │   │   ├── [       3750]  SequencePattern$RepeatPatternExpr.class
    │       │   │       │       │   │   ├── [       3471]  SequencePattern$RepeatState.class
    │       │   │       │       │   │   ├── [       3243]  SequencePattern$SequencePatternExpr.class
    │       │   │       │       │   │   ├── [       2926]  SequencePattern$State.class
    │       │   │       │       │   │   ├── [        749]  SequencePattern$VarGroupBindings.class
    │       │   │       │       │   │   ├── [       8588]  SequencePattern.class
    │       │   │       │       │   │   ├── [       8352]  SimpleCharStream.class
    │       │   │       │       │   │   ├── [       1289]  Token.class
    │       │   │       │       │   │   ├── [       2873]  TokenMgrError.class
    │       │   │       │       │   │   ├── [       1029]  TokenSequenceMatcher.class
    │       │   │       │       │   │   ├── [        573]  TokenSequenceParser$JJCalls.class
    │       │   │       │       │   │   ├── [        626]  TokenSequenceParser$LookaheadSuccess.class
    │       │   │       │       │   │   ├── [      43735]  TokenSequenceParser.class
    │       │   │       │       │   │   ├── [       1671]  TokenSequenceParserConstants.class
    │       │   │       │       │   │   ├── [      14318]  TokenSequenceParserTokenManager.class
    │       │   │       │       │   │   └── [       5838]  TokenSequencePattern.class
    │       │   │       │       │   ├── [       1829]  ValueLabel.class
    │       │   │       │       │   ├── [        680]  Word$WordFactoryHolder.class
    │       │   │       │       │   ├── [       1519]  Word.class
    │       │   │       │       │   ├── [       1054]  WordFactory.class
    │       │   │       │       │   ├── [       5252]  WordLemmaTag.class
    │       │   │       │       │   ├── [       1989]  WordLemmaTagFactory.class
    │       │   │       │       │   ├── [        698]  WordTag$LabelFactoryHolder.class
    │       │   │       │       │   ├── [       5038]  WordTag.class
    │       │   │       │       │   └── [       1653]  WordTagFactory.class
    │       │   │       │       ├── [       4096]  math
    │       │   │       │       │   ├── [       3201]  ADMath.class
    │       │   │       │       │   ├── [      36598]  ArrayMath.class
    │       │   │       │       │   ├── [       2695]  DoubleAD.class
    │       │   │       │       │   └── [      10816]  SloppyMath.class
    │       │   │       │       ├── [       4096]  maxent
    │       │   │       │       │   ├── [       2302]  CGRunner$LikelihoodFunction.class
    │       │   │       │       │   ├── [       2070]  CGRunner$MonitorFunction.class
    │       │   │       │       │   ├── [       4273]  CGRunner.class
    │       │   │       │       │   ├── [      19468]  Convert.class
    │       │   │       │       │   ├── [        344]  DataGeneric.class
    │       │   │       │       │   ├── [       9535]  Experiments.class
    │       │   │       │       │   ├── [       7083]  Feature.class
    │       │   │       │       │   ├── [       5357]  Features.class
    │       │   │       │       │   ├── [       4096]  iis
    │       │   │       │       │   │   └── [      22537]  LambdaSolve.class
    │       │   │       │       │   └── [       2121]  Problem.class
    │       │   │       │       ├── [       4096]  objectbank
    │       │   │       │       │   ├── [       2029]  DelimitRegExIterator$DelimitRegExIteratorFactory.class
    │       │   │       │       │   ├── [       5538]  DelimitRegExIterator.class
    │       │   │       │       │   ├── [        762]  IdentityFunction.class
    │       │   │       │       │   ├── [        339]  IteratorFromReaderFactory.class
    │       │   │       │       │   ├── [       1591]  LineIterator$LineIteratorFactory.class
    │       │   │       │       │   ├── [       3596]  LineIterator.class
    │       │   │       │       │   ├── [       2195]  ObjectBank$OBIterator.class
    │       │   │       │       │   ├── [        917]  ObjectBank$PathToFileFunction.class
    │       │   │       │       │   ├── [       9457]  ObjectBank.class
    │       │   │       │       │   ├── [       3473]  ReaderIteratorFactory$ReaderIterator.class
    │       │   │       │       │   ├── [       2512]  ReaderIteratorFactory.class
    │       │   │       │       │   ├── [       3010]  ResettableReaderIteratorFactory.class
    │       │   │       │       │   ├── [        691]  TokenizerFactory.class
    │       │   │       │       │   ├── [       1633]  XMLBeginEndIterator$XMLBeginEndIteratorFactory.class
    │       │   │       │       │   └── [       8269]  XMLBeginEndIterator.class
    │       │   │       │       ├── [       4096]  optimization
    │       │   │       │       │   ├── [       1710]  AbstractCachingDiffFloatFunction.class
    │       │   │       │       │   ├── [       1809]  AbstractCachingDiffFunction.class
    │       │   │       │       │   ├── [       1635]  AbstractStochasticCachingDiffFunction$SamplingMethod.class
    │       │   │       │       │   ├── [       7461]  AbstractStochasticCachingDiffFunction.class
    │       │   │       │       │   ├── [       1126]  AbstractStochasticCachingDiffUpdateFunction.class
    │       │   │       │       │   ├── [       1552]  CGMinimizer$OneDimDiffFunction.class
    │       │   │       │       │   ├── [        560]  CGMinimizer$Triple.class
    │       │   │       │       │   ├── [      10100]  CGMinimizer.class
    │       │   │       │       │   ├── [       2541]  CmdEvaluator.class
    │       │   │       │       │   ├── [        228]  DiffFloatFunction.class
    │       │   │       │       │   ├── [        213]  DiffFunction.class
    │       │   │       │       │   ├── [        156]  Evaluator.class
    │       │   │       │       │   ├── [        195]  FloatFunction.class
    │       │   │       │       │   ├── [        185]  Function.class
    │       │   │       │       │   ├── [       1074]  GoldenSectionLineSearch$1.class
    │       │   │       │       │   ├── [       1105]  GoldenSectionLineSearch$2.class
    │       │   │       │       │   ├── [       6670]  GoldenSectionLineSearch.class
    │       │   │       │       │   ├── [        210]  HasEvaluators.class
    │       │   │       │       │   ├── [        166]  HasFloatInitial.class
    │       │   │       │       │   ├── [        156]  HasInitial.class
    │       │   │       │       │   ├── [       2527]  HybridMinimizer.class
    │       │   │       │       │   ├── [        288]  LineSearcher.class
    │       │   │       │       │   ├── [       1366]  MemoryEvaluator.class
    │       │   │       │       │   ├── [        386]  Minimizer.class
    │       │   │       │       │   ├── [       1259]  QNMinimizer$eLineSearch.class
    │       │   │       │       │   ├── [       1236]  QNMinimizer$eScaling.class
    │       │   │       │       │   ├── [       1427]  QNMinimizer$eState.class
    │       │   │       │       │   ├── [        592]  QNMinimizer$MaxEvaluationsExceeded.class
    │       │   │       │       │   ├── [        749]  QNMinimizer$QNInfo$NegativeCurvature.class
    │       │   │       │       │   ├── [        734]  QNMinimizer$QNInfo$ZeroGradient.class
    │       │   │       │       │   ├── [       7300]  QNMinimizer$QNInfo.class
    │       │   │       │       │   ├── [       7560]  QNMinimizer$Record.class
    │       │   │       │       │   ├── [        583]  QNMinimizer$SurpriseConvergence.class
    │       │   │       │       │   ├── [      25057]  QNMinimizer.class
    │       │   │       │       │   ├── [       2005]  ResultStoringFloatMonitor.class
    │       │   │       │       │   ├── [       1987]  ResultStoringMonitor.class
    │       │   │       │       │   ├── [       1515]  ScaledSGDMinimizer$lagrange.class
    │       │   │       │       │   ├── [       1353]  ScaledSGDMinimizer$setFixedGain.class
    │       │   │       │       │   ├── [        932]  ScaledSGDMinimizer$weight.class
    │       │   │       │       │   ├── [      11653]  ScaledSGDMinimizer.class
    │       │   │       │       │   ├── [       1301]  SGDMinimizer$1.class
    │       │   │       │       │   ├── [       4585]  SGDMinimizer.class
    │       │   │       │       │   ├── [       4592]  SGDToQNMinimizer.class
    │       │   │       │       │   ├── [       1301]  SMDMinimizer$1.class
    │       │   │       │       │   ├── [       1401]  SMDMinimizer$setLam.class
    │       │   │       │       │   ├── [       1397]  SMDMinimizer$setMu.class
    │       │   │       │       │   ├── [       6566]  SMDMinimizer.class
    │       │   │       │       │   ├── [        587]  SQNMinimizer$SurpriseConvergence.class
    │       │   │       │       │   ├── [       5967]  SQNMinimizer.class
    │       │   │       │       │   ├── [       1986]  StochasticCalculateMethods.class
    │       │   │       │       │   ├── [      12346]  StochasticDiffFunctionTester.class
    │       │   │       │       │   ├── [        655]  StochasticInPlaceMinimizer$InvalidElementException.class
    │       │   │       │       │   ├── [      11381]  StochasticInPlaceMinimizer.class
    │       │   │       │       │   ├── [        627]  StochasticMinimizer$InvalidElementException.class
    │       │   │       │       │   ├── [        387]  StochasticMinimizer$PropertySetter.class
    │       │   │       │       │   ├── [       1409]  StochasticMinimizer$setGain.class
    │       │   │       │       │   └── [      16419]  StochasticMinimizer.class
    │       │   │       │       ├── [       4096]  parser
    │       │   │       │       │   ├── [       4096]  charniak
    │       │   │       │       │   │   ├── [       8671]  CharniakParser.class
    │       │   │       │       │   │   ├── [       5291]  CharniakScoredParsesReaderWriter$ScoredParsesIterator.class
    │       │   │       │       │   │   └── [       5963]  CharniakScoredParsesReaderWriter.class
    │       │   │       │       │   ├── [        610]  KBestViterbiParser.class
    │       │   │       │       │   ├── [      12288]  lexparser
    │       │   │       │       │   │   ├── [       7688]  AbstractDependencyGrammar.class
    │       │   │       │       │   │   ├── [       1797]  AbstractTreebankParserParams$1.class
    │       │   │       │       │   │   ├── [       2100]  AbstractTreebankParserParams$AnnotatePunctuationFunction.class
    │       │   │       │       │   │   ├── [       3009]  AbstractTreebankParserParams$RemoveGFSubcategoryStripper.class
    │       │   │       │       │   │   ├── [       2927]  AbstractTreebankParserParams$SubcategoryStripper.class
    │       │   │       │       │   │   ├── [       2276]  AbstractTreebankParserParams$TypedDependencyTyper.class
    │       │   │       │       │   │   ├── [       2076]  AbstractTreebankParserParams$UnorderedTypedDependencyTyper.class
    │       │   │       │       │   │   ├── [       1947]  AbstractTreebankParserParams$UnorderedUntypedDependencyTyper.class
    │       │   │       │       │   │   ├── [       2147]  AbstractTreebankParserParams$UntypedDependencyTyper.class
    │       │   │       │       │   │   ├── [      14140]  AbstractTreebankParserParams.class
    │       │   │       │       │   │   ├── [       5212]  AbstractTreeExtractor.class
    │       │   │       │       │   │   ├── [       3219]  ArabicTreebankParserParams$AddEquivalencedConjNode.class
    │       │   │       │       │   │   ├── [       2189]  ArabicTreebankParserParams$AddEquivalencedNodeFunction.class
    │       │   │       │       │   │   ├── [       2195]  ArabicTreebankParserParams$AddEquivalencedNodeFunctionVar.class
    │       │   │       │       │   │   ├── [       2992]  ArabicTreebankParserParams$AddRelativeNodeFunction.class
    │       │   │       │       │   │   ├── [       3236]  ArabicTreebankParserParams$AddRelativeNodeRegexFunction.class
    │       │   │       │       │   │   ├── [       2472]  ArabicTreebankParserParams$AnnotatePunctuationFunction2.class
    │       │   │       │       │   │   ├── [       3726]  ArabicTreebankParserParams$ArabicSubcategoryStripper.class
    │       │   │       │       │   │   ├── [       1563]  ArabicTreebankParserParams$SimpleStringFunction.class
    │       │   │       │       │   │   ├── [      26159]  ArabicTreebankParserParams.class
    │       │   │       │       │   │   ├── [      26566]  BaseLexicon.class
    │       │   │       │       │   │   ├── [      12126]  BaseUnknownWordModel.class
    │       │   │       │       │   │   ├── [        891]  BasicCategoryTagProjection.class
    │       │   │       │       │   │   ├── [       4879]  BiLexPCFGParser$N5BiLexPCFGParser.class
    │       │   │       │       │   │   ├── [      28135]  BiLexPCFGParser.class
    │       │   │       │       │   │   ├── [       8236]  BinaryGrammar.class
    │       │   │       │       │   │   ├── [       4958]  BinaryGrammarExtractor.class
    │       │   │       │       │   │   ├── [       4061]  BinaryRule.class
    │       │   │       │       │   │   ├── [       1536]  BoundaryRemover.class
    │       │   │       │       │   │   ├── [       3925]  ChineseCharacterBasedLexicon$Symbol.class
    │       │   │       │       │   │   ├── [      28678]  ChineseCharacterBasedLexicon.class
    │       │   │       │       │   │   ├── [      21157]  ChineseLexiconAndWordSegmenter.class
    │       │   │       │       │   │   ├── [       3391]  ChineseLexicon.class
    │       │   │       │       │   │   ├── [      14529]  ChineseSimWordAvgDepGrammar.class
    │       │   │       │       │   │   ├── [       3595]  ChineseTreebankParserParams$1.class
    │       │   │       │       │   │   ├── [      29287]  ChineseTreebankParserParams.class
    │       │   │       │       │   │   ├── [       2349]  CNFTransformers$FromCNFTransformer.class
    │       │   │       │       │   │   ├── [       3267]  CNFTransformers$ToCNFTransformer.class
    │       │   │       │       │   │   ├── [       2145]  CNFTransformers.class
    │       │   │       │       │   │   ├── [       4331]  CollinsPuncTransformer.class
    │       │   │       │       │   │   ├── [       2828]  Debinarizer.class
    │       │   │       │       │   │   ├── [        742]  DependencyGrammar.class
    │       │   │       │       │   │   ├── [       1557]  Edge.class
    │       │   │       │       │   │   ├── [       1970]  EnglishTreebankParserParams$1.class
    │       │   │       │       │   │   ├── [       1369]  EnglishTreebankParserParams$2.class
    │       │   │       │       │   │   ├── [       5008]  EnglishTreebankParserParams$EnglishSubcategoryStripper.class
    │       │   │       │       │   │   ├── [        812]  EnglishTreebankParserParams$EnglishTest.class
    │       │   │       │       │   │   ├── [       4272]  EnglishTreebankParserParams$EnglishTrain.class
    │       │   │       │       │   │   ├── [      48435]  EnglishTreebankParserParams.class
    │       │   │       │       │   │   ├── [      15497]  EnglishUnknownWordModel.class
    │       │   │       │       │   │   ├── [       3182]  EvalbFormatWriter.class
    │       │   │       │       │   │   ├── [       3421]  ExactGrammarCompactor.class
    │       │   │       │       │   │   ├── [      18573]  ExhaustiveDependencyParser.class
    │       │   │       │       │   │   ├── [       1782]  ExhaustivePCFGParser$Arc.class
    │       │   │       │       │   │   ├── [       1857]  ExhaustivePCFGParser$Derivation.class
    │       │   │       │       │   │   ├── [       1408]  ExhaustivePCFGParser$Vertex.class
    │       │   │       │       │   │   ├── [      49405]  ExhaustivePCFGParser.class
    │       │   │       │       │   │   ├── [        570]  Extractor.class
    │       │   │       │       │   │   ├── [       4952]  FactoredLexicon.class
    │       │   │       │       │   │   ├── [      24963]  FactoredParser.class
    │       │   │       │       │   │   ├── [       1963]  FastFactoredParser$BinaryHeadFinder.class
    │       │   │       │       │   │   ├── [       7336]  FastFactoredParser.class
    │       │   │       │       │   │   ├── [       3528]  FrenchTreebankParserParams$AddPOSSequenceFunction.class
    │       │   │       │       │   │   ├── [       3437]  FrenchTreebankParserParams$AddRelativeNodeFunction.class
    │       │   │       │       │   │   ├── [       1571]  FrenchTreebankParserParams$SimpleStringFunction.class
    │       │   │       │       │   │   ├── [      27120]  FrenchTreebankParserParams.class
    │       │   │       │       │   │   ├── [       1801]  GermanUnknownWordModel.class
    │       │   │       │       │   │   ├── [      18136]  GrammarCompactor.class
    │       │   │       │       │   │   ├── [        357]  GrammarProjection.class
    │       │   │       │       │   │   ├── [       3554]  HebrewTreebankParserParams.class
    │       │   │       │       │   │   ├── [       1020]  HookChart$ChartIndex.class
    │       │   │       │       │   │   ├── [        949]  HookChart$WeakChartIndex.class
    │       │   │       │       │   │   ├── [       7192]  HookChart.class
    │       │   │       │       │   │   ├── [       1856]  Hook.class
    │       │   │       │       │   │   ├── [       2480]  HTKLatticeReader$LatticeWord.class
    │       │   │       │       │   │   ├── [      15075]  HTKLatticeReader.class
    │       │   │       │       │   │   ├── [       2942]  IntDependency.class
    │       │   │       │       │   │   ├── [       1004]  Interner.class
    │       │   │       │       │   │   ├── [       6140]  IntTaggedWord.class
    │       │   │       │       │   │   ├── [       1297]  Item.class
    │       │   │       │       │   │   ├── [      10287]  IterativeCKYPCFGParser.class
    │       │   │       │       │   │   ├── [       4498]  Lattice.class
    │       │   │       │       │   │   ├── [       2190]  LatticeEdge.class
    │       │   │       │       │   │   ├── [        300]  LatticeScorer.class
    │       │   │       │       │   │   ├── [      45612]  LexicalizedParser.class
    │       │   │       │       │   │   ├── [      42667]  LexicalizedParserQuery.class
    │       │   │       │       │   │   ├── [       1299]  Lexicon.class
    │       │   │       │       │   │   ├── [       6187]  LinearGrammarSmoother.class
    │       │   │       │       │   │   ├── [        503]  MLEDependencyGrammar$EndHead.class
    │       │   │       │       │   │   ├── [      25096]  MLEDependencyGrammar.class
    │       │   │       │       │   │   ├── [       3860]  MLEDependencyGrammarExtractor.class
    │       │   │       │       │   │   ├── [       3134]  NegraPennCollinizer.class
    │       │   │       │       │   │   ├── [      11176]  NegraPennTreebankParserParams.class
    │       │   │       │       │   │   ├── [       5070]  NodePruner.class
    │       │   │       │       │   │   ├── [       1201]  NullGrammarProjection.class
    │       │   │       │       │   │   ├── [       2939]  Options$LexOptions.class
    │       │   │       │       │   │   ├── [      18999]  Options.class
    │       │   │       │       │   │   ├── [       1735]  OutsideRuleFilter$FA.class
    │       │   │       │       │   │   ├── [       5219]  OutsideRuleFilter.class
    │       │   │       │       │   │   ├── [       1154]  ParentAnnotationStats$1.class
    │       │   │       │       │   │   ├── [       1154]  ParentAnnotationStats$2.class
    │       │   │       │       │   │   ├── [       1597]  ParentAnnotationStats$3.class
    │       │   │       │       │   │   ├── [       1068]  ParentAnnotationStats$4.class
    │       │   │       │       │   │   ├── [       1123]  ParentAnnotationStats$5.class
    │       │   │       │       │   │   ├── [      15735]  ParentAnnotationStats.class
    │       │   │       │       │   │   ├── [       1039]  ParserAnnotations$ConstraintAnnotation.class
    │       │   │       │       │   │   ├── [        476]  ParserAnnotations.class
    │       │   │       │       │   │   ├── [        961]  ParserConstraint.class
    │       │   │       │       │   │   ├── [       5947]  PostSplitter.class
    │       │   │       │       │   │   ├── [       2796]  ProjectionScorer.class
    │       │   │       │       │   │   ├── [       3629]  RandomWalk.class
    │       │   │       │       │   │   ├── [        168]  Rule.class
    │       │   │       │       │   │   ├── [        407]  Scorer.class
    │       │   │       │       │   │   ├── [       1154]  SisterAnnotationStats$1.class
    │       │   │       │       │   │   ├── [       1154]  SisterAnnotationStats$2.class
    │       │   │       │       │   │   ├── [       1123]  SisterAnnotationStats$3.class
    │       │   │       │       │   │   ├── [      10166]  SisterAnnotationStats.class
    │       │   │       │       │   │   ├── [        228]  TagProjection.class
    │       │   │       │       │   │   ├── [       4182]  TestOptions.class
    │       │   │       │       │   │   ├── [       1126]  TestTagProjection.class
    │       │   │       │       │   │   ├── [       4976]  TrainOptions.class
    │       │   │       │       │   │   ├── [       2912]  TreeAnnotatorAndBinarizer$TreeNullAnnotator.class
    │       │   │       │       │   │   ├── [      11688]  TreeAnnotatorAndBinarizer.class
    │       │   │       │       │   │   ├── [       8788]  TreeAnnotator.class
    │       │   │       │       │   │   ├── [       1122]  TreebankAnnotator$1.class
    │       │   │       │       │   │   ├── [       5634]  TreebankAnnotator.class
    │       │   │       │       │   │   ├── [       3242]  TreebankLangParserParams.class
    │       │   │       │       │   │   ├── [       1115]  TreeBinarizer$1.class
    │       │   │       │       │   │   ├── [      17013]  TreeBinarizer.class
    │       │   │       │       │   │   ├── [       2859]  TreeCollinizer.class
    │       │   │       │       │   │   ├── [       1674]  TwinScorer.class
    │       │   │       │       │   │   ├── [      10118]  UnaryGrammar.class
    │       │   │       │       │   │   ├── [       3716]  UnaryRule.class
    │       │   │       │       │   │   └── [        995]  UnknownWordModel.class
    │       │   │       │       │   ├── [       4096]  metrics
    │       │   │       │       │   │   ├── [       3887]  AbstractEval$CatErrorEval.class
    │       │   │       │       │   │   ├── [       4318]  AbstractEval$RuleErrorEval.class
    │       │   │       │       │   │   ├── [       2223]  AbstractEval$ScoreEval.class
    │       │   │       │       │   │   ├── [       5708]  AbstractEval.class
    │       │   │       │       │   │   ├── [       2736]  Evalb$CBEval.class
    │       │   │       │       │   │   ├── [       1703]  Evalb$F1Comparator.class
    │       │   │       │       │   │   ├── [       8176]  EvalbByCat.class
    │       │   │       │       │   │   ├── [      13070]  Evalb.class
    │       │   │       │       │   │   ├── [      13798]  LeafAncestorEval.class
    │       │   │       │       │   │   ├── [      14931]  TaggingEval.class
    │       │   │       │       │   │   ├── [       1922]  UnlabeledAttachmentEval$1.class
    │       │   │       │       │   │   └── [       9696]  UnlabeledAttachmentEval.class
    │       │   │       │       │   ├── [        231]  Parser.class
    │       │   │       │       │   ├── [       4096]  tools
    │       │   │       │       │   │   └── [       2843]  PunctEquivalenceClasser.class
    │       │   │       │       │   ├── [        226]  ViterbiParser.class
    │       │   │       │       │   └── [        248]  ViterbiParserWithOptions.class
    │       │   │       │       ├── [       4096]  pipeline
    │       │   │       │       │   ├── [       1435]  Annotation.class
    │       │   │       │       │   ├── [       5242]  AnnotationPipeline.class
    │       │   │       │       │   ├── [        441]  AnnotationSerializer.class
    │       │   │       │       │   ├── [        188]  Annotator.class
    │       │   │       │       │   ├── [       2233]  AnnotatorPool.class
    │       │   │       │       │   ├── [       3096]  CharniakParserAnnotator.class
    │       │   │       │       │   ├── [      24819]  ChunkAnnotationUtils.class
    │       │   │       │       │   ├── [       7613]  CleanXmlAnnotator.class
    │       │   │       │       │   ├── [       4904]  CoreMapAggregator.class
    │       │   │       │       │   ├── [       1435]  CoreMapAttributeAggregator$1.class
    │       │   │       │       │   ├── [       1378]  CoreMapAttributeAggregator$2.class
    │       │   │       │       │   ├── [       1342]  CoreMapAttributeAggregator$3.class
    │       │   │       │       │   ├── [       1273]  CoreMapAttributeAggregator$4.class
    │       │   │       │       │   ├── [        979]  CoreMapAttributeAggregator$5.class
    │       │   │       │       │   ├── [       2181]  CoreMapAttributeAggregator$6.class
    │       │   │       │       │   ├── [       2122]  CoreMapAttributeAggregator$7.class
    │       │   │       │       │   ├── [       2122]  CoreMapAttributeAggregator$8.class
    │       │   │       │       │   ├── [       1941]  CoreMapAttributeAggregator$ConcatAggregator.class
    │       │   │       │       │   ├── [       2209]  CoreMapAttributeAggregator$ConcatCoreMapListAggregator.class
    │       │   │       │       │   ├── [       1831]  CoreMapAttributeAggregator$ConcatListAggregator.class
    │       │   │       │       │   ├── [       2214]  CoreMapAttributeAggregator$MostFreqAggregator.class
    │       │   │       │       │   ├── [       5542]  CoreMapAttributeAggregator.class
    │       │   │       │       │   ├── [        687]  CustomAnnotationSerializer$IntermediateEdge.class
    │       │   │       │       │   ├── [        754]  CustomAnnotationSerializer$IntermediateNode.class
    │       │   │       │       │   ├── [       1075]  CustomAnnotationSerializer$IntermediateSemanticGraph.class
    │       │   │       │       │   ├── [      17623]  CustomAnnotationSerializer.class
    │       │   │       │       │   ├── [       2919]  DefaultPaths.class
    │       │   │       │       │   ├── [       8312]  DeterministicCorefAnnotator.class
    │       │   │       │       │   ├── [       3416]  GenderAnnotator.class
    │       │   │       │       │   ├── [       1267]  LabeledChunkIdentifier$LabelTagType.class
    │       │   │       │       │   ├── [       6596]  LabeledChunkIdentifier.class
    │       │   │       │       │   ├── [       5408]  MorphaAnnotator.class
    │       │   │       │       │   ├── [       5271]  NERCombinerAnnotator.class
    │       │   │       │       │   ├── [       7680]  ParserAnnotator.class
    │       │   │       │       │   ├── [       6241]  ParserAnnotatorUtils.class
    │       │   │       │       │   ├── [       7042]  POSTaggerAnnotator.class
    │       │   │       │       │   ├── [       1654]  PTBTokenizerAnnotator.class
    │       │   │       │       │   ├── [       5214]  RegexNERAnnotator.class
    │       │   │       │       │   ├── [       1997]  Requirement.class
    │       │   │       │       │   ├── [       1235]  StanfordCoreNLP$10.class
    │       │   │       │       │   ├── [       1317]  StanfordCoreNLP$11.class
    │       │   │       │       │   ├── [       3092]  StanfordCoreNLP$12.class
    │       │   │       │       │   ├── [       1109]  StanfordCoreNLP$13.class
    │       │   │       │       │   ├── [       1375]  StanfordCoreNLP$14.class
    │       │   │       │       │   ├── [       1653]  StanfordCoreNLP$1.class
    │       │   │       │       │   ├── [       1924]  StanfordCoreNLP$2.class
    │       │   │       │       │   ├── [       2464]  StanfordCoreNLP$3.class
    │       │   │       │       │   ├── [       1814]  StanfordCoreNLP$4.class
    │       │   │       │       │   ├── [       1011]  StanfordCoreNLP$5.class
    │       │   │       │       │   ├── [       3744]  StanfordCoreNLP$6.class
    │       │   │       │       │   ├── [       1665]  StanfordCoreNLP$7.class
    │       │   │       │       │   ├── [       1317]  StanfordCoreNLP$8.class
    │       │   │       │       │   ├── [       1603]  StanfordCoreNLP$9.class
    │       │   │       │       │   ├── [      40375]  StanfordCoreNLP.class
    │       │   │       │       │   ├── [       3533]  StanfordCoreNLP.properties
    │       │   │       │       │   ├── [       2644]  TokenizerAnnotator.class
    │       │   │       │       │   ├── [       7380]  TrueCaseAnnotator.class
    │       │   │       │       │   ├── [       1835]  WhitespaceTokenizerAnnotator.class
    │       │   │       │       │   └── [       5223]  WordsToSentencesAnnotator.class
    │       │   │       │       ├── [       4096]  process
    │       │   │       │       │   ├── [       2307]  AbstractListProcessor.class
    │       │   │       │       │   ├── [       1754]  AbstractTokenizer.class
    │       │   │       │       │   ├── [      11946]  Americanize.class
    │       │   │       │       │   ├── [       3278]  CoreLabelTokenFactory.class
    │       │   │       │       │   ├── [        522]  CoreTokenFactory.class
    │       │   │       │       │   ├── [       1188]  DocumentPreprocessor$1.class
    │       │   │       │       │   ├── [       1256]  DocumentPreprocessor$DocType.class
    │       │   │       │       │   ├── [       1825]  DocumentPreprocessor$PlainTextIterator$1.class
    │       │   │       │       │   ├── [       5331]  DocumentPreprocessor$PlainTextIterator.class
    │       │   │       │       │   ├── [       2900]  DocumentPreprocessor$XMLIterator.class
    │       │   │       │       │   ├── [       9641]  DocumentPreprocessor.class
    │       │   │       │       │   ├── [        463]  DocumentProcessor.class
    │       │   │       │       │   ├── [       7033]  JFlexDummyLexer.class
    │       │   │       │       │   ├── [        302]  LexedTokenFactory.class
    │       │   │       │       │   ├── [       2500]  LexerTokenizer.class
    │       │   │       │       │   ├── [        332]  ListProcessor.class
    │       │   │       │       │   ├── [    1516900]  Morpha.class
    │       │   │       │       │   ├── [       8121]  Morphology.class
    │       │   │       │       │   ├── [      21982]  PTB2TextLexer.class
    │       │   │       │       │   ├── [       7780]  PTBEscapingProcessor.class
    │       │   │       │       │   ├── [       1476]  PTBLexer$UntokenizableOptions.class
    │       │   │       │       │   ├── [     261719]  PTBLexer.class
    │       │   │       │       │   ├── [       5299]  PTBTokenizer$PTBTokenizerFactory.class
    │       │   │       │       │   ├── [      14401]  PTBTokenizer.class
    │       │   │       │       │   ├── [        361]  SerializableFunction.class
    │       │   │       │       │   ├── [       4561]  StripTagsProcessor.class
    │       │   │       │       │   ├── [       1690]  TokenizerAdapter.class
    │       │   │       │       │   ├── [        436]  Tokenizer.class
    │       │   │       │       │   ├── [       3866]  TransformXML$SAXInterface.class
    │       │   │       │       │   ├── [       7194]  TransformXML.class
    │       │   │       │       │   ├── [       7781]  WhitespaceLexer.class
    │       │   │       │       │   ├── [       3317]  WhitespaceTokenizer$WhitespaceTokenizerFactory.class
    │       │   │       │       │   ├── [       5242]  WhitespaceTokenizer.class
    │       │   │       │       │   ├── [        468]  WordSegmenter.class
    │       │   │       │       │   ├── [       1973]  WordSegmentingTokenizer$WordSegmentingTokenizerFactory.class
    │       │   │       │       │   ├── [       2881]  WordSegmentingTokenizer.class
    │       │   │       │       │   ├── [      15084]  WordShapeClassifier.class
    │       │   │       │       │   ├── [        875]  WordTokenFactory.class
    │       │   │       │       │   └── [       8084]  WordToSentenceProcessor.class
    │       │   │       │       ├── [       4096]  sequences
    │       │   │       │       │   ├── [        753]  BeamBestSequenceFinder$TagSeq$TagList.class
    │       │   │       │       │   ├── [       2672]  BeamBestSequenceFinder$TagSeq.class
    │       │   │       │       │   ├── [       2150]  BeamBestSequenceFinder$TestSequenceModel.class
    │       │   │       │       │   ├── [       4767]  BeamBestSequenceFinder.class
    │       │   │       │       │   ├── [        216]  BestSequenceFinder.class
    │       │   │       │       │   ├── [       1120]  Clique$CliqueEqualityWrapper.class
    │       │   │       │       │   ├── [       4318]  Clique.class
    │       │   │       │       │   ├── [       3520]  ColumnDocumentReaderAndWriter$ColumnDocParser.class
    │       │   │       │       │   ├── [       4168]  ColumnDocumentReaderAndWriter.class
    │       │   │       │       │   ├── [       1541]  CoNLLDocumentReaderAndWriter$CoNLLIterator.class
    │       │   │       │       │   ├── [      12187]  CoNLLDocumentReaderAndWriter.class
    │       │   │       │       │   ├── [        873]  CoolingSchedule$1.class
    │       │   │       │       │   ├── [        824]  CoolingSchedule$2.class
    │       │   │       │       │   ├── [        897]  CoolingSchedule.class
    │       │   │       │       │   ├── [        613]  DocumentReaderAndWriter.class
    │       │   │       │       │   ├── [       2071]  ExactBestSequenceFinder$TestSequenceModel.class
    │       │   │       │       │   ├── [       5835]  ExactBestSequenceFinder.class
    │       │   │       │       │   ├── [       1395]  FactoredSequenceListener.class
    │       │   │       │       │   ├── [       2973]  FactoredSequenceModel.class
    │       │   │       │       │   ├── [       4962]  FeatureFactory.class
    │       │   │       │       │   ├── [       5531]  KBestSequenceFinder.class
    │       │   │       │       │   ├── [        389]  LatticeWriter.class
    │       │   │       │       │   ├── [       2121]  ObjectBankWrapper$WrappedIterator.class
    │       │   │       │       │   ├── [      10615]  ObjectBankWrapper.class
    │       │   │       │       │   ├── [       2732]  PlainTextDocumentReaderAndWriter$OutputStyle.class
    │       │   │       │       │   ├── [      13303]  PlainTextDocumentReaderAndWriter.class
    │       │   │       │       │   ├── [      48989]  SeqClassifierFlags.class
    │       │   │       │       │   ├── [       8013]  SequenceGibbsSampler.class
    │       │   │       │       │   ├── [        219]  SequenceListener.class
    │       │   │       │       │   ├── [        308]  SequenceModel.class
    │       │   │       │       │   ├── [       1856]  SequenceSampler$TestSequenceModel.class
    │       │   │       │       │   ├── [       2274]  SequenceSampler.class
    │       │   │       │       │   └── [       4965]  ViterbiSearchGraphBuilder.class
    │       │   │       │       ├── [       4096]  stats
    │       │   │       │       │   ├── [       1935]  AbstractCounter.class
    │       │   │       │       │   ├── [       5820]  AccuracyStats.class
    │       │   │       │       │   ├── [       1682]  ClassicCounter$1$1.class
    │       │   │       │       │   ├── [       1557]  ClassicCounter$1.class
    │       │   │       │       │   ├── [       2394]  ClassicCounter$2$1$1.class
    │       │   │       │       │   ├── [       1933]  ClassicCounter$2$1.class
    │       │   │       │       │   ├── [       1300]  ClassicCounter$2.class
    │       │   │       │       │   ├── [       1550]  ClassicCounter$ClassicCounterFactory.class
    │       │   │       │       │   ├── [      10934]  ClassicCounter.class
    │       │   │       │       │   ├── [       1379]  Counter.class
    │       │   │       │       │   ├── [       1067]  Counters$1.class
    │       │   │       │       │   ├── [       1344]  Counters$2.class
    │       │   │       │       │   ├── [       1077]  Counters$3.class
    │       │   │       │       │   ├── [       1355]  Counters$4.class
    │       │   │       │       │   ├── [       1313]  Counters$5.class
    │       │   │       │       │   ├── [       1732]  Counters$6$1$1$1.class
    │       │   │       │       │   ├── [       1655]  Counters$6$1$1.class
    │       │   │       │       │   ├── [       1266]  Counters$6$1.class
    │       │   │       │       │   ├── [       3861]  Counters$6.class
    │       │   │       │       │   ├── [       2871]  Counters$7$1$1$1.class
    │       │   │       │       │   ├── [       2205]  Counters$7$1$1.class
    │       │   │       │       │   ├── [       1509]  Counters$7$1.class
    │       │   │       │       │   ├── [       1266]  Counters$7$2.class
    │       │   │       │       │   ├── [       1312]  Counters$7$3$1.class
    │       │   │       │       │   ├── [       1050]  Counters$7$3.class
    │       │   │       │       │   ├── [       1546]  Counters$7$4$1.class
    │       │   │       │       │   ├── [       1101]  Counters$7$4.class
    │       │   │       │       │   ├── [       5692]  Counters$7.class
    │       │   │       │       │   ├── [       2342]  Counters$8.class
    │       │   │       │       │   ├── [       1105]  Counters$NaturalComparator.class
    │       │   │       │       │   ├── [      62236]  Counters.class
    │       │   │       │       │   ├── [       1010]  Distribution$1.class
    │       │   │       │       │   ├── [       3413]  Distribution$DynamicDistribution.class
    │       │   │       │       │   ├── [      23589]  Distribution.class
    │       │   │       │       │   ├── [        316]  EquivalenceClasser.class
    │       │   │       │       │   ├── [        649]  EquivalenceClassEval$1.class
    │       │   │       │       │   ├── [        749]  EquivalenceClassEval$2.class
    │       │   │       │       │   ├── [       1642]  EquivalenceClassEval$3.class
    │       │   │       │       │   ├── [       1291]  EquivalenceClassEval$4.class
    │       │   │       │       │   ├── [       2103]  EquivalenceClassEval$5.class
    │       │   │       │       │   ├── [        402]  EquivalenceClassEval$EqualityChecker.class
    │       │   │       │       │   ├── [       1881]  EquivalenceClassEval$Eval$CollectionContainsChecker.class
    │       │   │       │       │   ├── [       5946]  EquivalenceClassEval$Eval.class
    │       │   │       │       │   ├── [        478]  EquivalenceClassEval$Factory.class
    │       │   │       │       │   ├── [      18760]  EquivalenceClassEval.class
    │       │   │       │       │   ├── [       4453]  GeneralizedCounter$CounterView.class
    │       │   │       │       │   ├── [       2408]  GeneralizedCounter$Entry.class
    │       │   │       │       │   ├── [       4018]  GeneralizedCounter$OneDimensionalCounterView.class
    │       │   │       │       │   ├── [      20661]  GeneralizedCounter.class
    │       │   │       │       │   ├── [       2200]  IntCounter$1$1$1.class
    │       │   │       │       │   ├── [       1913]  IntCounter$1$1.class
    │       │   │       │       │   ├── [       1291]  IntCounter$1.class
    │       │   │       │       │   ├── [       1150]  IntCounter$2.class
    │       │   │       │       │   ├── [       1679]  IntCounter$3$1.class
    │       │   │       │       │   ├── [       1217]  IntCounter$3.class
    │       │   │       │       │   ├── [       1227]  IntCounter$NaturalComparator.class
    │       │   │       │       │   ├── [      16168]  IntCounter.class
    │       │   │       │       │   ├── [       9027]  MultiClassAccuracyStats.class
    │       │   │       │       │   ├── [       7826]  MultiClassChunkEvalStats.class
    │       │   │       │       │   ├── [       2175]  MultiClassPrecisionRecallExtendedStats$MultiClassStringLabelStats.class
    │       │   │       │       │   ├── [        972]  MultiClassPrecisionRecallExtendedStats$StringStringConverter.class
    │       │   │       │       │   ├── [      13328]  MultiClassPrecisionRecallExtendedStats.class
    │       │   │       │       │   ├── [       9724]  MultiClassPrecisionRecallStats.class
    │       │   │       │       │   ├── [        459]  ProbabilityDistribution.class
    │       │   │       │       │   ├── [        241]  Sampler.class
    │       │   │       │       │   ├── [        488]  Scorer.class
    │       │   │       │       │   ├── [       6643]  SimpleGoodTuring.class
    │       │   │       │       │   ├── [      15994]  TwoDimensionalCounter.class
    │       │   │       │       │   └── [       1399]  TwoDimensionalCounterInterface.class
    │       │   │       │       ├── [       4096]  tagger
    │       │   │       │       │   ├── [       4096]  common
    │       │   │       │       │   │   └── [        441]  TaggerConstants.class
    │       │   │       │       │   ├── [       4096]  io
    │       │   │       │       │   │   ├── [        423]  TaggedFileReader.class
    │       │   │       │       │   │   ├── [       1290]  TaggedFileRecord$Format.class
    │       │   │       │       │   │   ├── [       7734]  TaggedFileRecord.class
    │       │   │       │       │   │   ├── [       3611]  TextTaggedFileReader.class
    │       │   │       │       │   │   ├── [       3480]  TreeTaggedFileReader.class
    │       │   │       │       │   │   └── [       3756]  TSVTaggedFileReader.class
    │       │   │       │       │   └── [       4096]  maxent
    │       │   │       │       │       ├── [       3667]  AmbiguityClass.class
    │       │   │       │       │       ├── [       2164]  AmbiguityClasses.class
    │       │   │       │       │       ├── [       1766]  ASBCunkDetector.class
    │       │   │       │       │       ├── [       2912]  ASBCunkDict.class
    │       │   │       │       │       ├── [       2023]  CaselessCompanyNameDetector.class
    │       │   │       │       │       ├── [       2399]  CompanyNameDetector.class
    │       │   │       │       │       ├── [       2958]  CountWrapper.class
    │       │   │       │       │       ├── [       3267]  CtbDict.class
    │       │   │       │       │       ├── [       1984]  CtbPreDetector.class
    │       │   │       │       │       ├── [       2017]  CtbSufDetector.class
    │       │   │       │       │       ├── [       3052]  CTBunkDict.class
    │       │   │       │       │       ├── [       1771]  CTBunkDictDetector.class
    │       │   │       │       │       ├── [       1139]  CWordBooleanExtractor.class
    │       │   │       │       │       ├── [       1029]  DataWordTag.class
    │       │   │       │       │       ├── [       7660]  Dictionary.class
    │       │   │       │       │       ├── [        781]  DictionaryExtractor.class
    │       │   │       │       │       ├── [       1183]  ExtractorAllCap.class
    │       │   │       │       │       ├── [       1198]  ExtractorAllCapitalized.class
    │       │   │       │       │       ├── [       1746]  ExtractorCapC.class
    │       │   │       │       │       ├── [       2311]  ExtractorCapDistLC.class
    │       │   │       │       │       ├── [       2350]  ExtractorCapLCSeen.class
    │       │   │       │       │       ├── [       4442]  Extractor.class
    │       │   │       │       │       ├── [       1186]  ExtractorCNumber.class
    │       │   │       │       │       ├── [       1178]  ExtractorDash.class
    │       │   │       │       │       ├── [       2341]  ExtractorDistsim$ExtractorDistsimConjunction.class
    │       │   │       │       │       ├── [       3191]  ExtractorDistsim.class
    │       │   │       │       │       ├── [       1566]  ExtractorFrames$ExtractorContinuousTagConjunction.class
    │       │   │       │       │       ├── [       1469]  ExtractorFrames$ExtractorCWordCapCase.class
    │       │   │       │       │       ├── [       2307]  ExtractorFrames$ExtractorThreeTags.class
    │       │   │       │       │       ├── [       2177]  ExtractorFrames$ExtractorTwoTags.class
    │       │   │       │       │       ├── [       1984]  ExtractorFrames$ExtractorTwoWords.class
    │       │   │       │       │       ├── [       2260]  ExtractorFrames$ExtractorTwoWordsTag.class
    │       │   │       │       │       ├── [       1214]  ExtractorFrames$ExtractorWordLowerCase.class
    │       │   │       │       │       ├── [       1731]  ExtractorFrames$ExtractorWordTag.class
    │       │   │       │       │       ├── [       2244]  ExtractorFrames$ExtractorWordTwoTags.class
    │       │   │       │       │       ├── [       7505]  ExtractorFrames.class
    │       │   │       │       │       ├── [      12538]  ExtractorFramesRare.class
    │       │   │       │       │       ├── [        691]  ExtractorFrenchAdjSuffix.class
    │       │   │       │       │       ├── [        691]  ExtractorFrenchAdvSuffix.class
    │       │   │       │       │       ├── [        694]  ExtractorFrenchNounSuffix.class
    │       │   │       │       │       ├── [        702]  ExtractorFrenchPluralSuffix.class
    │       │   │       │       │       ├── [        694]  ExtractorFrenchVerbSuffix.class
    │       │   │       │       │       ├── [       1631]  ExtractorLetterDashDigit.class
    │       │   │       │       │       ├── [       1268]  ExtractorLetterDigitDash.class
    │       │   │       │       │       ├── [       1910]  ExtractorMidSentenceCapC.class
    │       │   │       │       │       ├── [       1344]  ExtractorMidSentenceCap.class
    │       │   │       │       │       ├── [       4596]  Extractors.class
    │       │   │       │       │       ├── [       2131]  ExtractorsConjunction.class
    │       │   │       │       │       ├── [       1912]  ExtractorStartSentenceCap.class
    │       │   │       │       │       ├── [       1185]  ExtractorUCase.class
    │       │   │       │       │       ├── [       1269]  ExtractorUpperDigitDash.class
    │       │   │       │       │       ├── [       3455]  ExtractorVerbalVBNZero.class
    │       │   │       │       │       ├── [       1858]  ExtractorWordPref.class
    │       │   │       │       │       ├── [       1297]  ExtractorWordShapeClassifier.class
    │       │   │       │       │       ├── [       2008]  ExtractorWordShapeConjunction.class
    │       │   │       │       │       ├── [       1861]  ExtractorWordSuff.class
    │       │   │       │       │       ├── [       2643]  FeatureKey.class
    │       │   │       │       │       ├── [       3597]  History.class
    │       │   │       │       │       ├── [       1395]  HistoryTable.class
    │       │   │       │       │       ├── [       7057]  LambdaSolveTagger.class
    │       │   │       │       │       ├── [       1512]  ListInstances.class
    │       │   │       │       │       ├── [       6567]  MaxentTagger$TaggerWrapper.class
    │       │   │       │       │       ├── [      38544]  MaxentTagger.class
    │       │   │       │       │       ├── [       1286]  MaxentTaggerGUI$1.class
    │       │   │       │       │       ├── [        820]  MaxentTaggerGUI$2.class
    │       │   │       │       │       ├── [        908]  MaxentTaggerGUI$3.class
    │       │   │       │       │       ├── [       1143]  MaxentTaggerGUI$4$1.class
    │       │   │       │       │       ├── [       1410]  MaxentTaggerGUI$4.class
    │       │   │       │       │       ├── [       4682]  MaxentTaggerGUI.class
    │       │   │       │       │       ├── [       2255]  PairsHolder.class
    │       │   │       │       │       ├── [       1490]  PluralAcronymDetector.class
    │       │   │       │       │       ├── [       2087]  RareExtractor.class
    │       │   │       │       │       ├── [       6223]  ReadDataTagged.class
    │       │   │       │       │       ├── [       3698]  TagCount.class
    │       │   │       │       │       ├── [       1361]  TaggerConfig$Mode.class
    │       │   │       │       │       ├── [      26472]  TaggerConfig.class
    │       │   │       │       │       ├── [      13781]  TaggerExperiments.class
    │       │   │       │       │       ├── [       3229]  TaggerFeature.class
    │       │   │       │       │       ├── [       2230]  TaggerFeatures.class
    │       │   │       │       │       ├── [       3828]  TemplateHash.class
    │       │   │       │       │       ├── [       7915]  TestClassifier.class
    │       │   │       │       │       ├── [      21295]  TestSentence.class
    │       │   │       │       │       └── [      11005]  TTags.class
    │       │   │       │       ├── [      12288]  time
    │       │   │       │       │   ├── [      13619]  DateTimeUtils.class
    │       │   │       │       │   ├── [       1350]  JodaTimeUtils$10.class
    │       │   │       │       │   ├── [       1343]  JodaTimeUtils$11.class
    │       │   │       │       │   ├── [       1018]  JodaTimeUtils$1.class
    │       │   │       │       │   ├── [       1020]  JodaTimeUtils$2.class
    │       │   │       │       │   ├── [       1017]  JodaTimeUtils$3.class
    │       │   │       │       │   ├── [       1019]  JodaTimeUtils$4.class
    │       │   │       │       │   ├── [       1447]  JodaTimeUtils$5.class
    │       │   │       │       │   ├── [       1450]  JodaTimeUtils$6.class
    │       │   │       │       │   ├── [       1451]  JodaTimeUtils$7.class
    │       │   │       │       │   ├── [       1454]  JodaTimeUtils$8.class
    │       │   │       │       │   ├── [       1412]  JodaTimeUtils$9.class
    │       │   │       │       │   ├── [      21729]  JodaTimeUtils.class
    │       │   │       │       │   ├── [       1284]  Options$RelativeHeuristicLevel.class
    │       │   │       │       │   ├── [       1924]  Options.class
    │       │   │       │       │   ├── [        806]  SUTime$10.class
    │       │   │       │       │   ├── [        764]  SUTime$11.class
    │       │   │       │       │   ├── [        492]  SUTime$12.class
    │       │   │       │       │   ├── [       1046]  SUTime$13.class
    │       │   │       │       │   ├── [        814]  SUTime$1.class
    │       │   │       │       │   ├── [        816]  SUTime$2.class
    │       │   │       │       │   ├── [        764]  SUTime$3.class
    │       │   │       │       │   ├── [        761]  SUTime$4.class
    │       │   │       │       │   ├── [        802]  SUTime$5.class
    │       │   │       │       │   ├── [        794]  SUTime$6.class
    │       │   │       │       │   ├── [        794]  SUTime$7.class
    │       │   │       │       │   ├── [        792]  SUTime$8.class
    │       │   │       │       │   ├── [        791]  SUTime$9.class
    │       │   │       │       │   ├── [       9220]  SUTime$CompositePartialTime.class
    │       │   │       │       │   ├── [       9696]  SUTime$Duration.class
    │       │   │       │       │   ├── [       2665]  SUTime$DurationRange.class
    │       │   │       │       │   ├── [       4946]  SUTime$DurationWithFields.class
    │       │   │       │       │   ├── [       2442]  SUTime$DurationWithMillis.class
    │       │   │       │       │   ├── [       3515]  SUTime$ExplicitTemporalSet.class
    │       │   │       │       │   ├── [       3772]  SUTime$GroundedTime.class
    │       │   │       │       │   ├── [       1391]  SUTime$InexactDuration.class
    │       │   │       │       │   ├── [       5865]  SUTime$InexactTime.class
    │       │   │       │       │   ├── [       4095]  SUTime$IsoDate.class
    │       │   │       │       │   ├── [       1127]  SUTime$IsoDateTime.class
    │       │   │       │       │   ├── [       2652]  SUTime$IsoTime.class
    │       │   │       │       │   ├── [       2113]  SUTime$OrdinalTime.class
    │       │   │       │       │   ├── [      14845]  SUTime$PartialTime.class
    │       │   │       │       │   ├── [       4536]  SUTime$PeriodicTemporalSet.class
    │       │   │       │       │   ├── [       9573]  SUTime$Range.class
    │       │   │       │       │   ├── [       1929]  SUTime$RefTime.class
    │       │   │       │       │   ├── [       6826]  SUTime$RelativeTime.class
    │       │   │       │       │   ├── [       1477]  SUTime$SimpleTime.class
    │       │   │       │       │   ├── [       1509]  SUTime$StandardTemporalType$1.class
    │       │   │       │       │   ├── [       1876]  SUTime$StandardTemporalType$2.class
    │       │   │       │       │   ├── [       1876]  SUTime$StandardTemporalType$3.class
    │       │   │       │       │   ├── [       1508]  SUTime$StandardTemporalType$4.class
    │       │   │       │       │   ├── [       1881]  SUTime$StandardTemporalType$5.class
    │       │   │       │       │   ├── [       1878]  SUTime$StandardTemporalType$6.class
    │       │   │       │       │   ├── [       1508]  SUTime$StandardTemporalType$7.class
    │       │   │       │       │   ├── [       1882]  SUTime$StandardTemporalType$8.class
    │       │   │       │       │   ├── [       5834]  SUTime$StandardTemporalType.class
    │       │   │       │       │   ├── [       7045]  SUTime$Temporal.class
    │       │   │       │       │   ├── [       1941]  SUTime$TemporalOp$10.class
    │       │   │       │       │   ├── [       1935]  SUTime$TemporalOp$11.class
    │       │   │       │       │   ├── [       1823]  SUTime$TemporalOp$12.class
    │       │   │       │       │   ├── [       1823]  SUTime$TemporalOp$13.class
    │       │   │       │       │   ├── [       1592]  SUTime$TemporalOp$14.class
    │       │   │       │       │   ├── [       1570]  SUTime$TemporalOp$15.class
    │       │   │       │       │   ├── [       1692]  SUTime$TemporalOp$1.class
    │       │   │       │       │   ├── [       2374]  SUTime$TemporalOp$2.class
    │       │   │       │       │   ├── [       1971]  SUTime$TemporalOp$3.class
    │       │   │       │       │   ├── [       1692]  SUTime$TemporalOp$4.class
    │       │   │       │       │   ├── [       2372]  SUTime$TemporalOp$5.class
    │       │   │       │       │   ├── [       1379]  SUTime$TemporalOp$6.class
    │       │   │       │       │   ├── [       1054]  SUTime$TemporalOp$7.class
    │       │   │       │       │   ├── [       1545]  SUTime$TemporalOp$8.class
    │       │   │       │       │   ├── [       2034]  SUTime$TemporalOp$9.class
    │       │   │       │       │   ├── [       4359]  SUTime$TemporalOp.class
    │       │   │       │       │   ├── [        860]  SUTime$TemporalSet.class
    │       │   │       │       │   ├── [       8495]  SUTime$Time.class
    │       │   │       │       │   ├── [       1867]  SUTime$TimeIndex.class
    │       │   │       │       │   ├── [       2658]  SUTime$TimeUnit.class
    │       │   │       │       │   ├── [       4362]  SUTime$TimeWithRange.class
    │       │   │       │       │   ├── [       1733]  SUTime$TimexAttr.class
    │       │   │       │       │   ├── [       1463]  SUTime$TimexDocFunc.class
    │       │   │       │       │   ├── [       2109]  SUTime$TimexMod.class
    │       │   │       │       │   ├── [       1238]  SUTime$TimexType.class
    │       │   │       │       │   ├── [      12791]  SUTime.class
    │       │   │       │       │   ├── [        777]  TimeAnnotations$TimexAnnotation.class
    │       │   │       │       │   ├── [        941]  TimeAnnotations$TimexAnnotations.class
    │       │   │       │       │   ├── [        509]  TimeAnnotations.class
    │       │   │       │       │   ├── [        743]  TimeExpression$Annotation.class
    │       │   │       │       │   ├── [        945]  TimeExpression$ChildrenAnnotation.class
    │       │   │       │       │   ├── [       5760]  TimeExpression.class
    │       │   │       │       │   ├── [       8187]  TimeExpressionExtractor$DurationRule.class
    │       │   │       │       │   ├── [       2805]  TimeExpressionExtractor$GenericTimePatternExtractor.class
    │       │   │       │       │   ├── [       3312]  TimeExpressionExtractor$IsoDateTimeExtractor.class
    │       │   │       │       │   ├── [       3079]  TimeExpressionExtractor$IsoDateTimePatternFunc.class
    │       │   │       │       │   ├── [       2667]  TimeExpressionExtractor$SequenceMatchExtractor.class
    │       │   │       │       │   ├── [       2251]  TimeExpressionExtractor$StringMatchExtractor.class
    │       │   │       │       │   ├── [       2334]  TimeExpressionExtractor$TemporalComposeFunc.class
    │       │   │       │       │   ├── [       2238]  TimeExpressionExtractor$TemporalComposeObjFunc.class
    │       │   │       │       │   ├── [       1220]  TimeExpressionExtractor$TemporalConstFunc.class
    │       │   │       │       │   ├── [        639]  TimeExpressionExtractor$TemporalExtractor.class
    │       │   │       │       │   ├── [       2070]  TimeExpressionExtractor$TemporalGetTEFunc.class
    │       │   │       │       │   ├── [       1567]  TimeExpressionExtractor$TemporalLookupFunc.class
    │       │   │       │       │   ├── [       1240]  TimeExpressionExtractor$TemporalOpConstFunc.class
    │       │   │       │       │   ├── [       1585]  TimeExpressionExtractor$TemporalOpLookupFunc.class
    │       │   │       │       │   ├── [       3684]  TimeExpressionExtractor$TimePatternExtractor.class
    │       │   │       │       │   ├── [      23382]  TimeExpressionExtractor.class
    │       │   │       │       │   ├── [       2642]  TimeExpressionPatterns$10.class
    │       │   │       │       │   ├── [       1602]  TimeExpressionPatterns$11.class
    │       │   │       │       │   ├── [       4559]  TimeExpressionPatterns$12.class
    │       │   │       │       │   ├── [       1825]  TimeExpressionPatterns$13.class
    │       │   │       │       │   ├── [       1367]  TimeExpressionPatterns$14.class
    │       │   │       │       │   ├── [       2065]  TimeExpressionPatterns$15.class
    │       │   │       │       │   ├── [       1758]  TimeExpressionPatterns$16.class
    │       │   │       │       │   ├── [       1758]  TimeExpressionPatterns$17.class
    │       │   │       │       │   ├── [       2138]  TimeExpressionPatterns$18.class
    │       │   │       │       │   ├── [       1683]  TimeExpressionPatterns$19.class
    │       │   │       │       │   ├── [       5064]  TimeExpressionPatterns$1.class
    │       │   │       │       │   ├── [       4696]  TimeExpressionPatterns$20.class
    │       │   │       │       │   ├── [       2355]  TimeExpressionPatterns$2.class
    │       │   │       │       │   ├── [       2357]  TimeExpressionPatterns$3.class
    │       │   │       │       │   ├── [       2624]  TimeExpressionPatterns$4.class
    │       │   │       │       │   ├── [       1433]  TimeExpressionPatterns$5.class
    │       │   │       │       │   ├── [       1429]  TimeExpressionPatterns$6.class
    │       │   │       │       │   ├── [       1890]  TimeExpressionPatterns$7.class
    │       │   │       │       │   ├── [       1955]  TimeExpressionPatterns$8.class
    │       │   │       │       │   ├── [       2975]  TimeExpressionPatterns$9.class
    │       │   │       │       │   ├── [       1336]  TimeExpressionPatterns$PatternFilter.class
    │       │   │       │       │   ├── [       1283]  TimeExpressionPatterns$PatternType.class
    │       │   │       │       │   ├── [       2004]  TimeExpressionPatterns$TimeExpressionTokenSeqFilter.class
    │       │   │       │       │   ├── [       1500]  TimeExpressionPatterns$TimexTypeMatchNodePattern.class
    │       │   │       │       │   ├── [       1517]  TimeExpressionPatterns$TokenSeqPatternFilter.class
    │       │   │       │       │   ├── [      53188]  TimeExpressionPatterns.class
    │       │   │       │       │   └── [      10080]  Timex.class
    │       │   │       │       ├── [      20480]  trees
    │       │   │       │       │   ├── [       5602]  AbstractCollinsHeadFinder.class
    │       │   │       │       │   ├── [       1293]  AbstractTreebankLanguagePack$BasicCategoryStringFunction.class
    │       │   │       │       │   ├── [       1317]  AbstractTreebankLanguagePack$CategoryAndFunctionStringFunction.class
    │       │   │       │       │   ├── [       8482]  AbstractTreebankLanguagePack.class
    │       │   │       │       │   ├── [       1427]  BobChrisTreeNormalizer$AOverAFilter.class
    │       │   │       │       │   ├── [       1385]  BobChrisTreeNormalizer$EmptyFilter.class
    │       │   │       │       │   ├── [       2204]  BobChrisTreeNormalizer.class
    │       │   │       │       │   ├── [        996]  CollinsHeadFinder$1.class
    │       │   │       │       │   ├── [       4909]  CollinsHeadFinder.class
    │       │   │       │       │   ├── [       2114]  CollocationFinder$Collocation.class
    │       │   │       │       │   ├── [      12368]  CollocationFinder.class
    │       │   │       │       │   ├── [       1766]  CompositeTreebank$CompositeTreebankIterator.class
    │       │   │       │       │   ├── [       1772]  CompositeTreebank.class
    │       │   │       │       │   ├── [       1579]  CompositeTreeTransformer.class
    │       │   │       │       │   ├── [       4574]  Constituent.class
    │       │   │       │       │   ├── [        289]  ConstituentFactory.class
    │       │   │       │       │   ├── [      11122]  CoordinationTransformer.class
    │       │   │       │       │   ├── [       1837]  Dependencies$ComparatorHolder$DependencyIdxComparator.class
    │       │   │       │       │   ├── [        933]  Dependencies$ComparatorHolder.class
    │       │   │       │       │   ├── [       1850]  Dependencies$DependentPuncTagRejectFilter.class
    │       │   │       │       │   ├── [       1960]  Dependencies$DependentPuncWordRejectFilter.class
    │       │   │       │       │   ├── [       4924]  Dependencies.class
    │       │   │       │       │   ├── [        646]  Dependency.class
    │       │   │       │       │   ├── [        384]  DependencyFactory.class
    │       │   │       │       │   ├── [        469]  DependencyPrinter.class
    │       │   │       │       │   ├── [        356]  DependencyReader.class
    │       │   │       │       │   ├── [       3842]  DependencyTreeTransformer.class
    │       │   │       │       │   ├── [        435]  DependencyTyper.class
    │       │   │       │       │   ├── [       6188]  DiskTreebank$DiskTreebankIterator.class
    │       │   │       │       │   ├── [       4088]  DiskTreebank.class
    │       │   │       │       │   ├── [        684]  EnglishGrammaticalRelations$AbbreviationModifierGRAnnotation.class
    │       │   │       │       │   ├── [        684]  EnglishGrammaticalRelations$AdjectivalComplementGRAnnotation.class
    │       │   │       │       │   ├── [        678]  EnglishGrammaticalRelations$AdjectivalModifierGRAnnotation.class
    │       │   │       │       │   ├── [        675]  EnglishGrammaticalRelations$AdvClauseModifierGRAnnotation.class
    │       │   │       │       │   ├── [        675]  EnglishGrammaticalRelations$AdverbialModifierGRAnnotation.class
    │       │   │       │       │   ├── [        639]  EnglishGrammaticalRelations$AgentGRAnnotation.class
    │       │   │       │       │   ├── [        684]  EnglishGrammaticalRelations$AppositionalModifierGRAnnotation.class
    │       │   │       │       │   ├── [        648]  EnglishGrammaticalRelations$ArgumentGRAnnotation.class
    │       │   │       │       │   ├── [        657]  EnglishGrammaticalRelations$AttributiveGRAnnotation.class
    │       │   │       │       │   ├── [        657]  EnglishGrammaticalRelations$AuxModifierGRAnnotation.class
    │       │   │       │       │   ├── [        654]  EnglishGrammaticalRelations$AuxPassiveGRAnnotation.class
    │       │   │       │       │   ├── [        675]  EnglishGrammaticalRelations$ClausalComplementGRAnnotation.class
    │       │   │       │       │   ├── [        687]  EnglishGrammaticalRelations$ClausalPassiveSubjectGRAnnotation.class
    │       │   │       │       │   ├── [        666]  EnglishGrammaticalRelations$ClausalSubjectGRAnnotation.class
    │       │   │       │       │   ├── [        654]  EnglishGrammaticalRelations$ComplementGRAnnotation.class
    │       │   │       │       │   ├── [        666]  EnglishGrammaticalRelations$ComplementizerGRAnnotation.class
    │       │   │       │       │   ├── [        648]  EnglishGrammaticalRelations$ConjunctGRAnnotation.class
    │       │   │       │       │   ├── [        678]  EnglishGrammaticalRelations$ControllingSubjectGRAnnotation.class
    │       │   │       │       │   ├── [        660]  EnglishGrammaticalRelations$CoordinationGRAnnotation.class
    │       │   │       │       │   ├── [        642]  EnglishGrammaticalRelations$CopulaGRAnnotation.class
    │       │   │       │       │   ├── [        654]  EnglishGrammaticalRelations$DeterminerGRAnnotation.class
    │       │   │       │       │   ├── [        660]  EnglishGrammaticalRelations$DirectObjectGRAnnotation.class
    │       │   │       │       │   ├── [        651]  EnglishGrammaticalRelations$ExpletiveGRAnnotation.class
    │       │   │       │       │   ├── [        666]  EnglishGrammaticalRelations$IndirectObjectGRAnnotation.class
    │       │   │       │       │   ├── [        681]  EnglishGrammaticalRelations$InfinitivalModifierGRAnnotation.class
    │       │   │       │       │   ├── [        642]  EnglishGrammaticalRelations$MarkerGRAnnotation.class
    │       │   │       │       │   ├── [        648]  EnglishGrammaticalRelations$ModifierGRAnnotation.class
    │       │   │       │       │   ├── [        681]  EnglishGrammaticalRelations$MultiWordExpressionGRAnnotation.class
    │       │   │       │       │   ├── [        672]  EnglishGrammaticalRelations$NegationModifierGRAnnotation.class
    │       │   │       │       │   ├── [        687]  EnglishGrammaticalRelations$NominalPassiveSubjectGRAnnotation.class
    │       │   │       │       │   ├── [        666]  EnglishGrammaticalRelations$NominalSubjectGRAnnotation.class
    │       │   │       │       │   ├── [        684]  EnglishGrammaticalRelations$NounCompoundModifierGRAnnotation.class
    │       │   │       │       │   ├── [        681]  EnglishGrammaticalRelations$NpAdverbialModifierGRAnnotation.class
    │       │   │       │       │   ├── [        666]  EnglishGrammaticalRelations$NumberModifierGRAnnotation.class
    │       │   │       │       │   ├── [        669]  EnglishGrammaticalRelations$NumericModifierGRAnnotation.class
    │       │   │       │       │   ├── [        642]  EnglishGrammaticalRelations$ObjectGRAnnotation.class
    │       │   │       │       │   ├── [        651]  EnglishGrammaticalRelations$ParataxisGRAnnotation.class
    │       │   │       │       │   ├── [        681]  EnglishGrammaticalRelations$ParticipialModifierGRAnnotation.class
    │       │   │       │       │   ├── [        681]  EnglishGrammaticalRelations$PhrasalVerbParticleGRAnnotation.class
    │       │   │       │       │   ├── [        678]  EnglishGrammaticalRelations$PossessionModifierGRAnnotation.class
    │       │   │       │       │   ├── [        678]  EnglishGrammaticalRelations$PossessiveModifierGRAnnotation.class
    │       │   │       │       │   ├── [        657]  EnglishGrammaticalRelations$PreconjunctGRAnnotation.class
    │       │   │       │       │   ├── [        663]  EnglishGrammaticalRelations$PredeterminerGRAnnotation.class
    │       │   │       │       │   ├── [        651]  EnglishGrammaticalRelations$PredicateGRAnnotation.class
    │       │   │       │       │   ├── [        693]  EnglishGrammaticalRelations$PrepositionalComplementGRAnnotation.class
    │       │   │       │       │   ├── [        687]  EnglishGrammaticalRelations$PrepositionalModifierGRAnnotation.class
    │       │   │       │       │   ├── [        681]  EnglishGrammaticalRelations$PrepositionalObjectGRAnnotation.class
    │       │   │       │       │   ├── [        657]  EnglishGrammaticalRelations$PunctuationGRAnnotation.class
    │       │   │       │       │   ├── [        687]  EnglishGrammaticalRelations$PurposeClauseModifierGRAnnotation.class
    │       │   │       │       │   ├── [        678]  EnglishGrammaticalRelations$QuantifierModifierGRAnnotation.class
    │       │   │       │       │   ├── [        648]  EnglishGrammaticalRelations$ReferentGRAnnotation.class
    │       │   │       │       │   ├── [        690]  EnglishGrammaticalRelations$RelativeClauseModifierGRAnnotation.class
    │       │   │       │       │   ├── [        648]  EnglishGrammaticalRelations$RelativeGRAnnotation.class
    │       │   │       │       │   ├── [        675]  EnglishGrammaticalRelations$SemanticDependentGRAnnotation.class
    │       │   │       │       │   ├── [        645]  EnglishGrammaticalRelations$SubjectGRAnnotation.class
    │       │   │       │       │   ├── [        672]  EnglishGrammaticalRelations$TemporalModifierGRAnnotation.class
    │       │   │       │       │   ├── [        678]  EnglishGrammaticalRelations$XClausalComplementGRAnnotation.class
    │       │   │       │       │   ├── [      49506]  EnglishGrammaticalRelations.class
    │       │   │       │       │   ├── [       1381]  EnglishGrammaticalStructure$FromDependenciesFactory.class
    │       │   │       │       │   ├── [      34985]  EnglishGrammaticalStructure.class
    │       │   │       │       │   ├── [       1320]  FilteringTreeReader.class
    │       │   │       │       │   ├── [        571]  GrammaticalRelation$DependentGRAnnotation.class
    │       │   │       │       │   ├── [        568]  GrammaticalRelation$GovernorGRAnnotation.class
    │       │   │       │       │   ├── [        876]  GrammaticalRelation$GrammaticalRelationAnnotation.class
    │       │   │       │       │   ├── [        556]  GrammaticalRelation$KillGRAnnotation.class
    │       │   │       │       │   ├── [       1293]  GrammaticalRelation$Language.class
    │       │   │       │       │   ├── [        556]  GrammaticalRelation$RootGRAnnotation.class
    │       │   │       │       │   ├── [      14727]  GrammaticalRelation.class
    │       │   │       │       │   ├── [        877]  GrammaticalStructure$1.class
    │       │   │       │       │   ├── [       1221]  GrammaticalStructure$NameComparator.class
    │       │   │       │       │   ├── [       1850]  GrammaticalStructure$NoPunctFilter.class
    │       │   │       │       │   ├── [       1751]  GrammaticalStructure$NoPunctTypedDependencyFilter.class
    │       │   │       │       │   ├── [       3844]  GrammaticalStructure$TreeBankGrammaticalStructureWrapper$GsIterator.class
    │       │   │       │       │   ├── [       2757]  GrammaticalStructure$TreeBankGrammaticalStructureWrapper.class
    │       │   │       │       │   ├── [      46844]  GrammaticalStructure.class
    │       │   │       │       │   ├── [       4104]  GrammaticalStructureFactory.class
    │       │   │       │       │   ├── [        476]  GrammaticalStructureFromDependenciesFactory.class
    │       │   │       │       │   ├── [        339]  HeadFinder.class
    │       │   │       │       │   ├── [       4096]  international
    │       │   │       │       │   │   ├── [       4096]  arabic
    │       │   │       │       │   │   │   ├── [       1309]  ArabicHeadFinder$TagSet$1.class
    │       │   │       │       │   │   │   ├── [       1317]  ArabicHeadFinder$TagSet$2.class
    │       │   │       │       │   │   │   ├── [       2351]  ArabicHeadFinder$TagSet.class
    │       │   │       │       │   │   │   ├── [       6668]  ArabicHeadFinder.class
    │       │   │       │       │   │   │   ├── [       4735]  ArabicTreebankLanguagePack.class
    │       │   │       │       │   │   │   ├── [       2306]  ArabicTreebankTokenizer.class
    │       │   │       │       │   │   │   ├── [       1395]  ArabicTreeNormalizer$ArabicEmptyFilter.class
    │       │   │       │       │   │   │   ├── [       7183]  ArabicTreeNormalizer.class
    │       │   │       │       │   │   │   ├── [        746]  ArabicTreeReaderFactory$ArabicRawTreeReaderFactory.class
    │       │   │       │       │   │   │   ├── [       1214]  ArabicTreeReaderFactory$XFilter.class
    │       │   │       │       │   │   │   └── [       2297]  ArabicTreeReaderFactory.class
    │       │   │       │       │   │   ├── [       4096]  french
    │       │   │       │       │   │   │   ├── [       1075]  DybroFrenchHeadFinder$1.class
    │       │   │       │       │   │   │   ├── [       3741]  DybroFrenchHeadFinder.class
    │       │   │       │       │   │   │   ├── [       1055]  FrenchHeadFinder$1.class
    │       │   │       │       │   │   │   ├── [       3779]  FrenchHeadFinder.class
    │       │   │       │       │   │   │   ├── [       2724]  FrenchTreebankLanguagePack.class
    │       │   │       │       │   │   │   ├── [       1420]  FrenchTreeNormalizer$1.class
    │       │   │       │       │   │   │   ├── [       1425]  FrenchTreeNormalizer$FrenchAOverAFilter.class
    │       │   │       │       │   │   │   ├── [       4400]  FrenchTreeNormalizer.class
    │       │   │       │       │   │   │   ├── [      12454]  FrenchTreeReader.class
    │       │   │       │       │   │   │   └── [       1394]  FrenchTreeReaderFactory.class
    │       │   │       │       │   │   ├── [       4096]  hebrew
    │       │   │       │       │   │   │   ├── [       2359]  HebrewTreebankLanguagePack.class
    │       │   │       │       │   │   │   ├── [       1178]  HebrewTreeNormalizer$HebrewEmptyFilter.class
    │       │   │       │       │   │   │   ├── [       2120]  HebrewTreeNormalizer.class
    │       │   │       │       │   │   │   └── [       3214]  HebrewTreeReaderFactory.class
    │       │   │       │       │   │   ├── [       4096]  negra
    │       │   │       │       │   │   │   ├── [       2457]  NegraLabel$NegraLabelFactory.class
    │       │   │       │       │   │   │   ├── [       2956]  NegraLabel.class
    │       │   │       │       │   │   │   ├── [       4290]  NegraPennLanguagePack.class
    │       │   │       │       │   │   │   ├── [       8558]  NegraPennLexer.class
    │       │   │       │       │   │   │   ├── [       1250]  NegraPennTokenizer.class
    │       │   │       │       │   │   │   ├── [       1720]  NegraPennTreeNormalizer$1.class
    │       │   │       │       │   │   │   ├── [       1499]  NegraPennTreeNormalizer$2.class
    │       │   │       │       │   │   │   ├── [       7350]  NegraPennTreeNormalizer.class
    │       │   │       │       │   │   │   ├── [       3582]  NegraPennTreeReaderFactory.class
    │       │   │       │       │   │   │   └── [       6471]  TigerHeadFinder.class
    │       │   │       │       │   │   └── [      12288]  pennchinese
    │       │   │       │       │   │       ├── [       3243]  BikelChineseHeadFinder.class
    │       │   │       │       │   │       ├── [       9251]  CharacterLevelTagExtender.class
    │       │   │       │       │   │       ├── [       3006]  ChineseCollinizer.class
    │       │   │       │       │   │       ├── [        862]  ChineseEnglishWordMap$SingletonHolder.class
    │       │   │       │       │   │       ├── [      12653]  ChineseEnglishWordMap.class
    │       │   │       │       │   │       ├── [       2751]  ChineseEscaper.class
    │       │   │       │       │   │       ├── [        756]  ChineseGrammaticalRelations$AdjectivalModifierGRAnnotation.class
    │       │   │       │       │   │       ├── [        753]  ChineseGrammaticalRelations$AdverbialModifierGRAnnotation.class
    │       │   │       │       │   │       ├── [        726]  ChineseGrammaticalRelations$ArgumentGRAnnotation.class
    │       │   │       │       │   │       ├── [        738]  ChineseGrammaticalRelations$AspectMarkerGRAnnotation.class
    │       │   │       │       │   │       ├── [        753]  ChineseGrammaticalRelations$AssociativeMarkerGRAnnotation.class
    │       │   │       │       │   │       ├── [        759]  ChineseGrammaticalRelations$AssociativeModifierGRAnnotation.class
    │       │   │       │       │   │       ├── [        735]  ChineseGrammaticalRelations$AttributiveGRAnnotation.class
    │       │   │       │       │   │       ├── [        735]  ChineseGrammaticalRelations$AuxModifierGRAnnotation.class
    │       │   │       │       │   │       ├── [        732]  ChineseGrammaticalRelations$AuxPassiveGRAnnotation.class
    │       │   │       │       │   │       ├── [        708]  ChineseGrammaticalRelations$BaGRAnnotation.class
    │       │   │       │       │   │       ├── [        753]  ChineseGrammaticalRelations$ClausalComplementGRAnnotation.class
    │       │   │       │       │   │       ├── [        744]  ChineseGrammaticalRelations$ClausalSubjectGRAnnotation.class
    │       │   │       │       │   │       ├── [        744]  ChineseGrammaticalRelations$ClauseModifierGRAnnotation.class
    │       │   │       │       │   │       ├── [        732]  ChineseGrammaticalRelations$ComplementGRAnnotation.class
    │       │   │       │       │   │       ├── [        744]  ChineseGrammaticalRelations$ComplementizerGRAnnotation.class
    │       │   │       │       │   │       ├── [        756]  ChineseGrammaticalRelations$ControllingSubjectGRAnnotation.class
    │       │   │       │       │   │       ├── [        738]  ChineseGrammaticalRelations$CoordinationGRAnnotation.class
    │       │   │       │       │   │       ├── [        732]  ChineseGrammaticalRelations$DeterminerGRAnnotation.class
    │       │   │       │       │   │       ├── [        738]  ChineseGrammaticalRelations$DirectObjectGRAnnotation.class
    │       │   │       │       │   │       ├── [        729]  ChineseGrammaticalRelations$DvpMarkerGRAnnotation.class
    │       │   │       │       │   │       ├── [        735]  ChineseGrammaticalRelations$DvpModifierGRAnnotation.class
    │       │   │       │       │   │       ├── [        711]  ChineseGrammaticalRelations$EtcGRAnnotation.class
    │       │   │       │       │   │       ├── [        759]  ChineseGrammaticalRelations$LocalizerComplementGRAnnotation.class
    │       │   │       │       │   │       ├── [        717]  ChineseGrammaticalRelations$ModalGRAnnotation.class
    │       │   │       │       │   │       ├── [        726]  ChineseGrammaticalRelations$ModifierGRAnnotation.class
    │       │   │       │       │   │       ├── [        750]  ChineseGrammaticalRelations$NegationModifierGRAnnotation.class
    │       │   │       │       │   │       ├── [        765]  ChineseGrammaticalRelations$NominalPassiveSubjectGRAnnotation.class
    │       │   │       │       │   │       ├── [        744]  ChineseGrammaticalRelations$NominalSubjectGRAnnotation.class
    │       │   │       │       │   │       ├── [        762]  ChineseGrammaticalRelations$NounCompoundModifierGRAnnotation.class
    │       │   │       │       │   │       ├── [        744]  ChineseGrammaticalRelations$NumberModifierGRAnnotation.class
    │       │   │       │       │   │       ├── [        747]  ChineseGrammaticalRelations$NumericModifierGRAnnotation.class
    │       │   │       │       │   │       ├── [        720]  ChineseGrammaticalRelations$ObjectGRAnnotation.class
    │       │   │       │       │   │       ├── [        729]  ChineseGrammaticalRelations$OrdNumberGRAnnotation.class
    │       │   │       │       │   │       ├── [        741]  ChineseGrammaticalRelations$ParentheticalGRAnnotation.class
    │       │   │       │       │   │       ├── [        759]  ChineseGrammaticalRelations$ParticipialModifierGRAnnotation.class
    │       │   │       │       │   │       ├── [        735]  ChineseGrammaticalRelations$PreconjunctGRAnnotation.class
    │       │   │       │       │   │       ├── [        792]  ChineseGrammaticalRelations$PrepositionalLocalizerModifierGRAnnotation.class
    │       │   │       │       │   │       ├── [        765]  ChineseGrammaticalRelations$PrepositionalModifierGRAnnotation.class
    │       │   │       │       │   │       ├── [        759]  ChineseGrammaticalRelations$PrepositionalObjectGRAnnotation.class
    │       │   │       │       │   │       ├── [        735]  ChineseGrammaticalRelations$PunctuationGRAnnotation.class
    │       │   │       │       │   │       ├── [        717]  ChineseGrammaticalRelations$RangeGRAnnotation.class
    │       │   │       │       │   │       ├── [        768]  ChineseGrammaticalRelations$RelativeClauseModifierGRAnnotation.class
    │       │   │       │       │   │       ├── [        765]  ChineseGrammaticalRelations$ResultativeComplementGRAnnotation.class
    │       │   │       │       │   │       ├── [        753]  ChineseGrammaticalRelations$SemanticDependentGRAnnotation.class
    │       │   │       │       │   │       ├── [        723]  ChineseGrammaticalRelations$SubjectGRAnnotation.class
    │       │   │       │       │   │       ├── [        744]  ChineseGrammaticalRelations$TemporalClauseGRAnnotation.class
    │       │   │       │       │   │       ├── [        726]  ChineseGrammaticalRelations$TemporalGRAnnotation.class
    │       │   │       │       │   │       ├── [        750]  ChineseGrammaticalRelations$TimePostpositionGRAnnotation.class
    │       │   │       │       │   │       ├── [        717]  ChineseGrammaticalRelations$TopicGRAnnotation.class
    │       │   │       │       │   │       ├── [        738]  ChineseGrammaticalRelations$VerbCompoundGRAnnotation.class
    │       │   │       │       │   │       ├── [        738]  ChineseGrammaticalRelations$VerbModifierGRAnnotation.class
    │       │   │       │       │   │       ├── [        756]  ChineseGrammaticalRelations$XClausalComplementGRAnnotation.class
    │       │   │       │       │   │       ├── [      21009]  ChineseGrammaticalRelations.class
    │       │   │       │       │   │       ├── [       1511]  ChineseGrammaticalStructure$FromDependenciesFactory.class
    │       │   │       │       │   │       ├── [      13420]  ChineseGrammaticalStructure.class
    │       │   │       │       │   │       ├── [       3467]  ChineseHeadFinder.class
    │       │   │       │       │   │       ├── [       1783]  ChineseSemanticHeadFinder.class
    │       │   │       │       │   │       ├── [       8745]  ChineseTreebankLanguagePack.class
    │       │   │       │       │   │       ├── [      12122]  CHTBLexer.class
    │       │   │       │       │   │       ├── [       2069]  CHTBTokenizer.class
    │       │   │       │       │   │       ├── [       2261]  CTBErrorCorrectingTreeNormalizer$ChineseEmptyFilter.class
    │       │   │       │       │   │       ├── [       7322]  CTBErrorCorrectingTreeNormalizer.class
    │       │   │       │       │   │       ├── [       1573]  CTBTreeReaderFactory.class
    │       │   │       │       │   │       ├── [       1498]  FragDiscardingPennTreeReader.class
    │       │   │       │       │   │       ├── [      72563]  RadicalMap.class
    │       │   │       │       │   │       └── [       2888]  SunJurafskyChineseHeadFinder.class
    │       │   │       │       │   ├── [        459]  Labeled.class
    │       │   │       │       │   ├── [       1306]  LabeledConstituent$ConstituentFactoryHolder$LabeledConstituentFactory.class
    │       │   │       │       │   ├── [        866]  LabeledConstituent$ConstituentFactoryHolder.class
    │       │   │       │       │   ├── [       1410]  LabeledConstituent$LabeledConstituentLabelFactory.class
    │       │   │       │       │   ├── [        806]  LabeledConstituent$LabelFactoryHolder.class
    │       │   │       │       │   ├── [       2015]  LabeledConstituent.class
    │       │   │       │       │   ├── [        819]  LabeledScoredConstituent$ConstituentFactoryHolder.class
    │       │   │       │       │   ├── [       1467]  LabeledScoredConstituent$LabeledScoredConstituentLabelFactory.class
    │       │   │       │       │   ├── [        860]  LabeledScoredConstituent$LabelFactoryHolder.class
    │       │   │       │       │   ├── [       1683]  LabeledScoredConstituent.class
    │       │   │       │       │   ├── [        930]  LabeledScoredConstituentFactory.class
    │       │   │       │       │   ├── [       2125]  LabeledScoredTreeFactory.class
    │       │   │       │       │   ├── [        663]  LabeledScoredTreeNode$TreeFactoryHolder.class
    │       │   │       │       │   ├── [       3593]  LabeledScoredTreeNode.class
    │       │   │       │       │   ├── [       1400]  LabeledScoredTreeReaderFactory.class
    │       │   │       │       │   ├── [        955]  LeftHeadFinder.class
    │       │   │       │       │   ├── [        754]  MemoryTreebank$1.class
    │       │   │       │       │   ├── [      13484]  MemoryTreebank.class
    │       │   │       │       │   ├── [       5253]  ModCollinsHeadFinder.class
    │       │   │       │       │   ├── [        893]  NamedDependency$DependencyFactoryHolder.class
    │       │   │       │       │   ├── [       1627]  NamedDependency$NamedDependencyFactory.class
    │       │   │       │       │   ├── [       2917]  NamedDependency.class
    │       │   │       │       │   ├── [       2023]  NPTmpRetainingTreeNormalizer$1.class
    │       │   │       │       │   ├── [       1806]  NPTmpRetainingTreeNormalizer$2.class
    │       │   │       │       │   ├── [       1655]  NPTmpRetainingTreeNormalizer$3.class
    │       │   │       │       │   ├── [       5990]  NPTmpRetainingTreeNormalizer$4.class
    │       │   │       │       │   ├── [        987]  NPTmpRetainingTreeNormalizer$NPTmpRetainingTreeReaderFactory.class
    │       │   │       │       │   ├── [       8939]  NPTmpRetainingTreeNormalizer.class
    │       │   │       │       │   ├── [       5214]  PennTreebankLanguagePack.class
    │       │   │       │       │   ├── [        944]  PennTreebankTokenizer$EnglishTreebankStreamTokenizer.class
    │       │   │       │       │   ├── [        706]  PennTreebankTokenizer.class
    │       │   │       │       │   ├── [       6120]  PennTreeReader.class
    │       │   │       │       │   ├── [       1538]  PennTreeReaderFactory.class
    │       │   │       │       │   ├── [       4911]  QPTreeTransformer.class
    │       │   │       │       │   ├── [      11958]  SemanticHeadFinder.class
    │       │   │       │       │   ├── [       4096]  semgraph
    │       │   │       │       │   │   ├── [       6188]  SemanticGraph$SemanticGraphParsingTask.class
    │       │   │       │       │   │   ├── [      48109]  SemanticGraph.class
    │       │   │       │       │   │   ├── [        949]  SemanticGraphCoreAnnotations$BasicDependenciesAnnotation.class
    │       │   │       │       │   │   ├── [        994]  SemanticGraphCoreAnnotations$CollapsedCCProcessedDependenciesAnnotation.class
    │       │   │       │       │   │   ├── [        961]  SemanticGraphCoreAnnotations$CollapsedDependenciesAnnotation.class
    │       │   │       │       │   │   ├── [        830]  SemanticGraphCoreAnnotations.class
    │       │   │       │       │   │   ├── [       1758]  SemanticGraphEdge$SemanticGraphEdgeTargetComparator.class
    │       │   │       │       │   │   ├── [       4572]  SemanticGraphEdge.class
    │       │   │       │       │   │   ├── [      14330]  SemanticGraphFactory.class
    │       │   │       │       │   │   └── [       7716]  SemanticGraphFormatter.class
    │       │   │       │       │   ├── [       1248]  SimpleConstituent$ConstituentFactoryHolder$SimpleConstituentFactory.class
    │       │   │       │       │   ├── [        857]  SimpleConstituent$ConstituentFactoryHolder.class
    │       │   │       │       │   ├── [        797]  SimpleConstituent$LabelFactoryHolder.class
    │       │   │       │       │   ├── [       1290]  SimpleConstituent$SimpleConstituentLabelFactory.class
    │       │   │       │       │   ├── [       1575]  SimpleConstituent.class
    │       │   │       │       │   ├── [        851]  SimpleConstituentFactory.class
    │       │   │       │       │   ├── [        612]  SimpleTree$TreeFactoryHolder.class
    │       │   │       │       │   ├── [       1941]  SimpleTree.class
    │       │   │       │       │   ├── [       1540]  SimpleTreeFactory.class
    │       │   │       │       │   ├── [       1118]  Span$ConstituentFactoryHolder$SpanFactory.class
    │       │   │       │       │   ├── [        849]  Span$ConstituentFactoryHolder.class
    │       │   │       │       │   ├── [        952]  Span.class
    │       │   │       │       │   ├── [        778]  TransformingTreebank$1.class
    │       │   │       │       │   ├── [        778]  TransformingTreebank$2.class
    │       │   │       │       │   ├── [       1796]  TransformingTreebank$MyTreeTransformer2.class
    │       │   │       │       │   ├── [       1796]  TransformingTreebank$MyTreeTransformer3.class
    │       │   │       │       │   ├── [       1792]  TransformingTreebank$MyTreeTransformer.class
    │       │   │       │       │   ├── [       1754]  TransformingTreebank$TransformingTreebankIterator.class
    │       │   │       │       │   ├── [       5450]  TransformingTreebank.class
    │       │   │       │       │   ├── [       1809]  Tree$TreeIterator.class
    │       │   │       │       │   ├── [       1027]  Treebank$1.class
    │       │   │       │       │   ├── [        851]  Treebank$CounterTreeProcessor.class
    │       │   │       │       │   ├── [      12853]  Treebank.class
    │       │   │       │       │   ├── [        191]  TreebankFactory.class
    │       │   │       │       │   ├── [       2858]  TreebankLanguagePack.class
    │       │   │       │       │   ├── [      47363]  Tree.class
    │       │   │       │       │   ├── [        802]  TreeCoreAnnotations$HeadTagAnnotation.class
    │       │   │       │       │   ├── [        805]  TreeCoreAnnotations$HeadWordAnnotation.class
    │       │   │       │       │   ├── [        793]  TreeCoreAnnotations$TreeAnnotation.class
    │       │   │       │       │   ├── [        629]  TreeCoreAnnotations.class
    │       │   │       │       │   ├── [        681]  TreeFactory.class
    │       │   │       │       │   ├── [       2477]  TreeFunctions$LabeledToDescriptiveCoreLabelTreeFunction.class
    │       │   │       │       │   ├── [       2518]  TreeFunctions$LabeledTreeToCategoryWordTagTreeFunction.class
    │       │   │       │       │   ├── [       2509]  TreeFunctions$LabeledTreeToStringLabeledTreeFunction.class
    │       │   │       │       │   ├── [       2992]  TreeFunctions.class
    │       │   │       │       │   ├── [       3182]  TreeGraph.class
    │       │   │       │       │   ├── [        642]  TreeGraphNode$TreeFactoryHolder.class
    │       │   │       │       │   ├── [      16768]  TreeGraphNode.class
    │       │   │       │       │   ├── [       2053]  TreeGraphNodeFactory.class
    │       │   │       │       │   ├── [       1622]  TreeLeafLabelTransformer.class
    │       │   │       │       │   ├── [       1028]  TreeLengthComparator.class
    │       │   │       │       │   ├── [        949]  TreeNormalizer.class
    │       │   │       │       │   ├── [       2208]  TreePrint$1.class
    │       │   │       │       │   ├── [       1034]  TreePrint$2.class
    │       │   │       │       │   ├── [      29209]  TreePrint.class
    │       │   │       │       │   ├── [        257]  TreeReader.class
    │       │   │       │       │   ├── [        218]  TreeReaderFactory.class
    │       │   │       │       │   ├── [      20428]  Trees.class
    │       │   │       │       │   ├── [       2884]  TreeToBracketProcessor.class
    │       │   │       │       │   ├── [       1650]  TreeTokenizerFactory$1.class
    │       │   │       │       │   ├── [       1855]  TreeTokenizerFactory.class
    │       │   │       │       │   ├── [        221]  TreeTransformer.class
    │       │   │       │       │   ├── [        181]  TreeVisitor.class
    │       │   │       │       │   ├── [       4096]  tregex
    │       │   │       │       │   │   ├── [       3996]  CoordinationPattern$CoordinationMatcher.class
    │       │   │       │       │   │   ├── [       4064]  CoordinationPattern.class
    │       │   │       │       │   │   ├── [       8756]  DescriptionPattern$DescriptionMatcher.class
    │       │   │       │       │   │   ├── [       1390]  DescriptionPattern$DescriptionMode.class
    │       │   │       │       │   │   ├── [       7664]  DescriptionPattern.class
    │       │   │       │       │   │   ├── [       3629]  Macros.class
    │       │   │       │       │   │   ├── [       3764]  ParseException.class
    │       │   │       │       │   │   ├── [        989]  Relation$1$1.class
    │       │   │       │       │   │   ├── [       2055]  Relation$10$1.class
    │       │   │       │       │   │   ├── [       1625]  Relation$10.class
    │       │   │       │       │   │   ├── [       1844]  Relation$11$1.class
    │       │   │       │       │   │   ├── [       1625]  Relation$11.class
    │       │   │       │       │   │   ├── [       1261]  Relation$12$1.class
    │       │   │       │       │   │   ├── [       1600]  Relation$12.class
    │       │   │       │       │   │   ├── [       1260]  Relation$13$1.class
    │       │   │       │       │   │   ├── [       1627]  Relation$13.class
    │       │   │       │       │   │   ├── [       1539]  Relation$14$1.class
    │       │   │       │       │   │   ├── [       1541]  Relation$14.class
    │       │   │       │       │   │   ├── [       1538]  Relation$15$1.class
    │       │   │       │       │   │   ├── [       1542]  Relation$15.class
    │       │   │       │       │   │   ├── [       1663]  Relation$16$1.class
    │       │   │       │       │   │   ├── [       1710]  Relation$16.class
    │       │   │       │       │   │   ├── [       1640]  Relation$17$1.class
    │       │   │       │       │   │   ├── [       1841]  Relation$17.class
    │       │   │       │       │   │   ├── [       1602]  Relation$18$1.class
    │       │   │       │       │   │   ├── [       1532]  Relation$18.class
    │       │   │       │       │   │   ├── [       1590]  Relation$19$1.class
    │       │   │       │       │   │   ├── [       1837]  Relation$19.class
    │       │   │       │       │   │   ├── [       1426]  Relation$1.class
    │       │   │       │       │   │   ├── [       1554]  Relation$20$1.class
    │       │   │       │       │   │   ├── [       1542]  Relation$20.class
    │       │   │       │       │   │   ├── [       1449]  Relation$21$1.class
    │       │   │       │       │   │   ├── [       1634]  Relation$21.class
    │       │   │       │       │   │   ├── [       1192]  Relation$22$1.class
    │       │   │       │       │   │   ├── [       1588]  Relation$22.class
    │       │   │       │       │   │   ├── [       1704]  Relation$23$1.class
    │       │   │       │       │   │   ├── [       1635]  Relation$23.class
    │       │   │       │       │   │   ├── [       1968]  Relation$24$1.class
    │       │   │       │       │   │   ├── [       1681]  Relation$24.class
    │       │   │       │       │   │   ├── [       1441]  Relation$2.class
    │       │   │       │       │   │   ├── [       1431]  Relation$3.class
    │       │   │       │       │   │   ├── [       1699]  Relation$4$1.class
    │       │   │       │       │   │   ├── [       1524]  Relation$4.class
    │       │   │       │       │   │   ├── [       1346]  Relation$5$1.class
    │       │   │       │       │   │   ├── [       1523]  Relation$5.class
    │       │   │       │       │   │   ├── [       1214]  Relation$6$1.class
    │       │   │       │       │   │   ├── [       1660]  Relation$6.class
    │       │   │       │       │   │   ├── [       1260]  Relation$7$1.class
    │       │   │       │       │   │   ├── [       1523]  Relation$7.class
    │       │   │       │       │   │   ├── [       2055]  Relation$8$1.class
    │       │   │       │       │   │   ├── [       1621]  Relation$8.class
    │       │   │       │       │   │   ├── [       1837]  Relation$9$1.class
    │       │   │       │       │   │   ├── [       1621]  Relation$9.class
    │       │   │       │       │   │   ├── [       1615]  Relation$HasIthChild$1.class
    │       │   │       │       │   │   ├── [       2638]  Relation$HasIthChild.class
    │       │   │       │       │   │   ├── [       1625]  Relation$HeadedBy$1.class
    │       │   │       │       │   │   ├── [       2380]  Relation$HeadedBy.class
    │       │   │       │       │   │   ├── [       1632]  Relation$Heads$1.class
    │       │   │       │       │   │   ├── [       2393]  Relation$Heads.class
    │       │   │       │       │   │   ├── [       1679]  Relation$ImmediatelyHeadedBy$1.class
    │       │   │       │       │   │   ├── [       2531]  Relation$ImmediatelyHeadedBy.class
    │       │   │       │       │   │   ├── [       1670]  Relation$ImmediatelyHeads$1.class
    │       │   │       │       │   │   ├── [       2311]  Relation$ImmediatelyHeads.class
    │       │   │       │       │   │   ├── [       1768]  Relation$IthChildOf$1.class
    │       │   │       │       │   │   ├── [       2625]  Relation$IthChildOf.class
    │       │   │       │       │   │   ├── [       1409]  Relation$SearchNodeIterator.class
    │       │   │       │       │   │   ├── [       1987]  Relation$UnbrokenCategoryDominates$1.class
    │       │   │       │       │   │   ├── [       4256]  Relation$UnbrokenCategoryDominates.class
    │       │   │       │       │   │   ├── [       3143]  Relation$UnbrokenCategoryFollows$1.class
    │       │   │       │       │   │   ├── [       3531]  Relation$UnbrokenCategoryFollows.class
    │       │   │       │       │   │   ├── [       1956]  Relation$UnbrokenCategoryIsDominatedBy$1.class
    │       │   │       │       │   │   ├── [       3110]  Relation$UnbrokenCategoryIsDominatedBy.class
    │       │   │       │       │   │   ├── [       3166]  Relation$UnbrokenCategoryPrecedes$1.class
    │       │   │       │       │   │   ├── [       3537]  Relation$UnbrokenCategoryPrecedes.class
    │       │   │       │       │   │   ├── [       9268]  Relation.class
    │       │   │       │       │   │   ├── [       8344]  SimpleCharStream.class
    │       │   │       │       │   │   ├── [       1273]  Token.class
    │       │   │       │       │   │   ├── [       2865]  TokenMgrError.class
    │       │   │       │       │   │   ├── [       4074]  TregexMatcher.class
    │       │   │       │       │   │   ├── [        483]  TregexParseException.class
    │       │   │       │       │   │   ├── [      15408]  TregexParser.class
    │       │   │       │       │   │   ├── [       1167]  TregexParserConstants.class
    │       │   │       │       │   │   ├── [      10600]  TregexParserTokenManager.class
    │       │   │       │       │   │   ├── [        885]  TregexPattern$TRegexTreeReaderFactory$1.class
    │       │   │       │       │   │   ├── [       1286]  TregexPattern$TRegexTreeReaderFactory.class
    │       │   │       │       │   │   ├── [       4507]  TregexPattern$TRegexTreeVisitor.class
    │       │   │       │       │   │   ├── [      15366]  TregexPattern.class
    │       │   │       │       │   │   ├── [       4202]  TregexPatternCompiler.class
    │       │   │       │       │   │   ├── [       4096]  tsurgeon
    │       │   │       │       │   │   │   ├── [       2641]  AdjoinNode.class
    │       │   │       │       │   │   │   ├── [       2230]  AdjoinToFootNode.class
    │       │   │       │       │   │   │   ├── [       1616]  AdjoinToHeadNode.class
    │       │   │       │       │   │   │   ├── [       7738]  AuxiliaryTree.class
    │       │   │       │       │   │   │   ├── [       1752]  CoindexationGenerator.class
    │       │   │       │       │   │   │   ├── [       2192]  CoindexNodes.class
    │       │   │       │       │   │   │   ├── [       2082]  DeleteNode.class
    │       │   │       │       │   │   │   ├── [       2710]  ExciseNode.class
    │       │   │       │       │   │   │   ├── [       1941]  FetchNode.class
    │       │   │       │       │   │   │   ├── [       1346]  HoldTreeNode.class
    │       │   │       │       │   │   │   ├── [       2895]  InsertNode.class
    │       │   │       │       │   │   │   ├── [       2965]  JJTTsurgeonParserState.class
    │       │   │       │       │   │   │   ├── [       2844]  MoveNode.class
    │       │   │       │       │   │   │   ├── [        499]  Node.class
    │       │   │       │       │   │   │   ├── [       3818]  ParseException.class
    │       │   │       │       │   │   │   ├── [       2350]  PruneNode.class
    │       │   │       │       │   │   │   ├── [       1312]  RelabelNode$RelabelMode.class
    │       │   │       │       │   │   │   ├── [       6122]  RelabelNode.class
    │       │   │       │       │   │   │   ├── [       1942]  ReplaceNode.class
    │       │   │       │       │   │   │   ├── [       8362]  SimpleCharStream.class
    │       │   │       │       │   │   │   ├── [       2795]  SimpleNode.class
    │       │   │       │       │   │   │   ├── [       1309]  Token.class
    │       │   │       │       │   │   │   ├── [       2883]  TokenMgrError.class
    │       │   │       │       │   │   │   ├── [       3483]  TreeLocation.class
    │       │   │       │       │   │   │   ├── [      14373]  Tsurgeon.class
    │       │   │       │       │   │   │   ├── [        507]  TsurgeonParseException.class
    │       │   │       │       │   │   │   ├── [        573]  TsurgeonParser$JJCalls.class
    │       │   │       │       │   │   │   ├── [        621]  TsurgeonParser$LookaheadSuccess.class
    │       │   │       │       │   │   │   ├── [      24268]  TsurgeonParser.class
    │       │   │       │       │   │   │   ├── [       1845]  TsurgeonParserConstants.class
    │       │   │       │       │   │   │   ├── [      15028]  TsurgeonParserTokenManager.class
    │       │   │       │       │   │   │   ├── [        943]  TsurgeonParserTreeConstants.class
    │       │   │       │       │   │   │   ├── [       1802]  TsurgeonPattern.class
    │       │   │       │       │   │   │   └── [       1762]  TsurgeonPatternRoot.class
    │       │   │       │       │   │   └── [       2698]  VariableStrings.class
    │       │   │       │       │   ├── [       3792]  TypedDependency.class
    │       │   │       │       │   ├── [        983]  UnnamedConcreteDependency$DependencyFactoryHolder.class
    │       │   │       │       │   ├── [       1698]  UnnamedConcreteDependency$UnnamedConcreteDependencyFactory.class
    │       │   │       │       │   ├── [       3767]  UnnamedConcreteDependency.class
    │       │   │       │       │   ├── [        911]  UnnamedDependency$DependencyFactoryHolder.class
    │       │   │       │       │   ├── [       1626]  UnnamedDependency$UnnamedDependencyFactory.class
    │       │   │       │       │   ├── [       3946]  UnnamedDependency.class
    │       │   │       │       │   ├── [       1094]  WordCatConstituent.class
    │       │   │       │       │   ├── [       1130]  WordCatEqualityChecker.class
    │       │   │       │       │   ├── [        706]  WordCatEquivalenceClasser.class
    │       │   │       │       │   ├── [        188]  WordNetConnection.class
    │       │   │       │       │   └── [       2200]  WordStemmer.class
    │       │   │       │       └── [      12288]  util
    │       │   │       │           ├── [        741]  AbstractIterator.class
    │       │   │       │           ├── [       1841]  ArrayCoreMap$1$1.class
    │       │   │       │           ├── [       1164]  ArrayCoreMap$1.class
    │       │   │       │           ├── [       1277]  ArrayCoreMap$2.class
    │       │   │       │           ├── [       9338]  ArrayCoreMap.class
    │       │   │       │           ├── [        735]  ArrayHeap$HeapEntry.class
    │       │   │       │           ├── [       8506]  ArrayHeap.class
    │       │   │       │           ├── [       1164]  ArrayIterable$1.class
    │       │   │       │           ├── [        922]  ArrayIterable.class
    │       │   │       │           ├── [       1378]  ArrayMap$1.class
    │       │   │       │           ├── [       2213]  ArrayMap$Entry.class
    │       │   │       │           ├── [       4671]  ArrayMap.class
    │       │   │       │           ├── [       1430]  ArraySet.class
    │       │   │       │           ├── [      18249]  ArrayUtils.class
    │       │   │       │           ├── [       2848]  Beam.class
    │       │   │       │           ├── [       1280]  BinaryHeapPriorityQueue$Entry.class
    │       │   │       │           ├── [      13539]  BinaryHeapPriorityQueue.class
    │       │   │       │           ├── [       2642]  ByteStreamGobbler.class
    │       │   │       │           ├── [        671]  Characters$CharacterHolder.class
    │       │   │       │           ├── [       1793]  Characters.class
    │       │   │       │           ├── [       1068]  CollectionFactory$ArrayListFactory.class
    │       │   │       │           ├── [       1056]  CollectionFactory$HashSetFactory.class
    │       │   │       │           ├── [       1073]  CollectionFactory$LinkedListFactory.class
    │       │   │       │           ├── [       1179]  CollectionFactory$SizedArrayListFactory.class
    │       │   │       │           ├── [       1056]  CollectionFactory$TreeSetFactory.class
    │       │   │       │           ├── [       2259]  CollectionFactory.class
    │       │   │       │           ├── [       1044]  CollectionUtils$1.class
    │       │   │       │           ├── [      26057]  CollectionUtils.class
    │       │   │       │           ├── [      12014]  CollectionValuedMap.class
    │       │   │       │           ├── [       1059]  Comparators$1.class
    │       │   │       │           ├── [       1257]  Comparators$2.class
    │       │   │       │           ├── [       1989]  Comparators.class
    │       │   │       │           ├── [       2385]  ConcatenationIterator.class
    │       │   │       │           ├── [       4096]  concurrent
    │       │   │       │           │   ├── [       1248]  SynchronizedInterner$1.class
    │       │   │       │           │   └── [       4298]  SynchronizedInterner.class
    │       │   │       │           ├── [       3746]  ConcurrentHashSet.class
    │       │   │       │           ├── [        365]  CoreMap.class
    │       │   │       │           ├── [       1190]  DataFilePaths.class
    │       │   │       │           ├── [       1772]  DeltaCollectionValuedMap$1$1.class
    │       │   │       │           ├── [       1493]  DeltaCollectionValuedMap$1$2.class
    │       │   │       │           ├── [       2779]  DeltaCollectionValuedMap$1.class
    │       │   │       │           ├── [       2661]  DeltaCollectionValuedMap$SimpleEntry.class
    │       │   │       │           ├── [       5983]  DeltaCollectionValuedMap.class
    │       │   │       │           ├── [       1388]  DeltaIndex$1.class
    │       │   │       │           ├── [       5798]  DeltaIndex.class
    │       │   │       │           ├── [       1536]  DeltaMap$1$1.class
    │       │   │       │           ├── [       2075]  DeltaMap$1$1NullingIterator.class
    │       │   │       │           ├── [       1359]  DeltaMap$1$2.class
    │       │   │       │           ├── [       2482]  DeltaMap$1.class
    │       │   │       │           ├── [       2522]  DeltaMap$SimpleEntry.class
    │       │   │       │           ├── [       4958]  DeltaMap.class
    │       │   │       │           ├── [       3698]  EditDistance.class
    │       │   │       │           ├── [       2100]  ErasureUtils.class
    │       │   │       │           ├── [        286]  Factory.class
    │       │   │       │           ├── [       1860]  FilePathProcessor.class
    │       │   │       │           ├── [        171]  FileProcessor.class
    │       │   │       │           ├── [        286]  Filter.class
    │       │   │       │           ├── [        953]  FilteredIterator$1.class
    │       │   │       │           ├── [       3287]  FilteredIterator.class
    │       │   │       │           ├── [        955]  Filters$CategoricalFilter.class
    │       │   │       │           ├── [       1387]  Filters$CollectionAcceptFilter.class
    │       │   │       │           ├── [       1387]  Filters$CombinedFilter.class
    │       │   │       │           ├── [       1372]  Filters$NegatedFilter.class
    │       │   │       │           ├── [       4698]  Filters.class
    │       │   │       │           ├── [       7482]  FixedPrioritiesPriorityQueue.class
    │       │   │       │           ├── [        282]  Function.class
    │       │   │       │           ├── [        417]  FuzzyInterval$FuzzyComparable.class
    │       │   │       │           ├── [       4642]  FuzzyInterval.class
    │       │   │       │           ├── [       7751]  Generics.class
    │       │   │       │           ├── [        603]  HashableCoreMap$HashableCoreMapException.class
    │       │   │       │           ├── [       3996]  HashableCoreMap.class
    │       │   │       │           ├── [        939]  HashIndex$1.class
    │       │   │       │           ├── [        861]  HashIndex$2.class
    │       │   │       │           ├── [       9948]  HashIndex.class
    │       │   │       │           ├── [       1026]  HasInterval$1.class
    │       │   │       │           ├── [        659]  HasInterval.class
    │       │   │       │           ├── [        501]  Heap.class
    │       │   │       │           ├── [       5967]  IdentityHashSet.class
    │       │   │       │           ├── [       1115]  Index.class
    │       │   │       │           ├── [       3338]  Interner.class
    │       │   │       │           ├── [       1639]  Interval$RelType.class
    │       │   │       │           ├── [      10197]  Interval.class
    │       │   │       │           ├── [       8779]  IntervalTree.class
    │       │   │       │           ├── [       1161]  IntPair.class
    │       │   │       │           ├── [       1105]  IntQuadruple.class
    │       │   │       │           ├── [        964]  IntTriple.class
    │       │   │       │           ├── [       4301]  IntTuple.class
    │       │   │       │           ├── [        907]  IntUni.class
    │       │   │       │           ├── [       2116]  IterableIterator.class
    │       │   │       │           ├── [       4096]  logging
    │       │   │       │           │   ├── [       1625]  Color.class
    │       │   │       │           │   ├── [       1454]  LogRecordHandler.class
    │       │   │       │           │   ├── [        790]  OutputHandler$TrackInfo.class
    │       │   │       │           │   ├── [      10541]  OutputHandler.class
    │       │   │       │           │   ├── [        389]  PrettyLoggable.class
    │       │   │       │           │   ├── [       1251]  PrettyLogger$1.class
    │       │   │       │           │   ├── [       8716]  PrettyLogger.class
    │       │   │       │           │   ├── [       1967]  Redwood$1.class
    │       │   │       │           │   ├── [       2372]  Redwood$2.class
    │       │   │       │           │   ├── [       2111]  Redwood$3.class
    │       │   │       │           │   ├── [        606]  Redwood$4.class
    │       │   │       │           │   ├── [       1492]  Redwood$5.class
    │       │   │       │           │   ├── [       1423]  Redwood$6.class
    │       │   │       │           │   ├── [       1017]  Redwood$ConsoleHandler.class
    │       │   │       │           │   ├── [       1129]  Redwood$FileHandler.class
    │       │   │       │           │   ├── [       1386]  Redwood$Flag.class
    │       │   │       │           │   ├── [       1327]  Redwood$MessageType.class
    │       │   │       │           │   ├── [       1272]  Redwood$Record$1.class
    │       │   │       │           │   ├── [       2681]  Redwood$Record.class
    │       │   │       │           │   ├── [       2524]  Redwood$RecordHandlerTree$1.class
    │       │   │       │           │   ├── [       6901]  Redwood$RecordHandlerTree.class
    │       │   │       │           │   ├── [       2067]  Redwood$RedwoodChannels.class
    │       │   │       │           │   ├── [       2149]  Redwood$Util$1.class
    │       │   │       │           │   ├── [       8936]  Redwood$Util.class
    │       │   │       │           │   ├── [      25941]  Redwood.class
    │       │   │       │           │   ├── [        871]  RedwoodConfiguration$10.class
    │       │   │       │           │   ├── [        871]  RedwoodConfiguration$11.class
    │       │   │       │           │   ├── [        767]  RedwoodConfiguration$12$1.class
    │       │   │       │           │   ├── [       1057]  RedwoodConfiguration$12.class
    │       │   │       │           │   ├── [        953]  RedwoodConfiguration$13.class
    │       │   │       │           │   ├── [        964]  RedwoodConfiguration$14.class
    │       │   │       │           │   ├── [        968]  RedwoodConfiguration$15.class
    │       │   │       │           │   ├── [        927]  RedwoodConfiguration$1.class
    │       │   │       │           │   ├── [       1092]  RedwoodConfiguration$2.class
    │       │   │       │           │   ├── [       1270]  RedwoodConfiguration$3.class
    │       │   │       │           │   ├── [       1458]  RedwoodConfiguration$4.class
    │       │   │       │           │   ├── [        989]  RedwoodConfiguration$5.class
    │       │   │       │           │   ├── [       1053]  RedwoodConfiguration$6.class
    │       │   │       │           │   ├── [       1410]  RedwoodConfiguration$7.class
    │       │   │       │           │   ├── [       1392]  RedwoodConfiguration$8.class
    │       │   │       │           │   ├── [        934]  RedwoodConfiguration$9.class
    │       │   │       │           │   ├── [      12878]  RedwoodConfiguration.class
    │       │   │       │           │   ├── [        784]  RedwoodPrintStream$1.class
    │       │   │       │           │   ├── [       7015]  RedwoodPrintStream.class
    │       │   │       │           │   ├── [       2598]  RepeatedRecordHandler$ApproximateRepeatSemantics.class
    │       │   │       │           │   ├── [       1966]  RepeatedRecordHandler$ExactRepeatSemantics.class
    │       │   │       │           │   ├── [       1378]  RepeatedRecordHandler$PendingType.class
    │       │   │       │           │   ├── [       3176]  RepeatedRecordHandler$RepeatedRecordInfo.class
    │       │   │       │           │   ├── [        610]  RepeatedRecordHandler$RepeatSemantics.class
    │       │   │       │           │   ├── [       7948]  RepeatedRecordHandler.class
    │       │   │       │           │   ├── [       1496]  Style.class
    │       │   │       │           │   ├── [       1261]  VisibilityHandler$State.class
    │       │   │       │           │   └── [       3633]  VisibilityHandler.class
    │       │   │       │           ├── [        946]  LowercaseFunction.class
    │       │   │       │           ├── [       1734]  MapFactory$ArrayMapFactory.class
    │       │   │       │           ├── [       1722]  MapFactory$HashMapFactory.class
    │       │   │       │           ├── [       1770]  MapFactory$IdentityHashMapFactory.class
    │       │   │       │           ├── [       1746]  MapFactory$LinkedHashMapFactory.class
    │       │   │       │           ├── [       1710]  MapFactory$TreeMapFactory.class
    │       │   │       │           ├── [       1746]  MapFactory$WeakHashMapFactory.class
    │       │   │       │           ├── [       2965]  MapFactory.class
    │       │   │       │           ├── [       1197]  Maps$1.class
    │       │   │       │           ├── [       7566]  Maps.class
    │       │   │       │           ├── [       2193]  MemoryMonitor$PeakMemoryMonitor.class
    │       │   │       │           ├── [       6510]  MemoryMonitor.class
    │       │   │       │           ├── [       1569]  MetaClass$ClassCreationException.class
    │       │   │       │           ├── [       7961]  MetaClass$ClassFactory.class
    │       │   │       │           ├── [       1250]  MetaClass$ConstructorNotFoundException.class
    │       │   │       │           ├── [       9893]  MetaClass.class
    │       │   │       │           ├── [       2154]  MutableDouble.class
    │       │   │       │           ├── [       2046]  MutableInteger.class
    │       │   │       │           ├── [       2442]  PaddedList.class
    │       │   │       │           ├── [       1664]  Pair$MutableInternedPair.class
    │       │   │       │           ├── [       5796]  Pair.class
    │       │   │       │           ├── [        641]  PriorityQueue.class
    │       │   │       │           ├── [       6840]  PropertiesUtils.class
    │       │   │       │           ├── [        558]  ReflectionLoading$ReflectionLoadingException.class
    │       │   │       │           ├── [       1058]  ReflectionLoading.class
    │       │   │       │           ├── [        137]  Scored.class
    │       │   │       │           ├── [       2084]  ScoredComparator.class
    │       │   │       │           ├── [       1620]  ScoredObject.class
    │       │   │       │           ├── [       4272]  Sets.class
    │       │   │       │           ├── [       1754]  StreamGobbler.class
    │       │   │       │           ├── [        744]  StringParsingTask$ParserException.class
    │       │   │       │           ├── [       3507]  StringParsingTask.class
    │       │   │       │           ├── [       1001]  StringUtils$1.class
    │       │   │       │           ├── [      36515]  StringUtils.class
    │       │   │       │           ├── [        707]  SystemUtils$ProcessException.class
    │       │   │       │           ├── [       2555]  SystemUtils$ProcessOutputStream.class
    │       │   │       │           ├── [       1286]  SystemUtils$WriterThread.class
    │       │   │       │           ├── [       5682]  SystemUtils.class
    │       │   │       │           ├── [       4315]  Timing.class
    │       │   │       │           ├── [       4043]  Triple.class
    │       │   │       │           ├── [        295]  TypesafeMap$Key.class
    │       │   │       │           ├── [       1150]  TypesafeMap.class
    │       │   │       │           ├── [       2293]  XMLUtils$SAXErrorHandler.class
    │       │   │       │           ├── [       2132]  XMLUtils$XMLTag.class
    │       │   │       │           └── [      19512]  XMLUtils.class
    │       │   │       └── [       4096]  umbc
    │       │   │           ├── [       4096]  dbpedia
    │       │   │           │   ├── [       4096]  model
    │       │   │           │   │   ├── [       1265]  BestCombinationElement.class
    │       │   │           │   │   ├── [       1812]  ChoiceElement.class
    │       │   │           │   │   ├── [       1335]  CoElement.class
    │       │   │           │   │   ├── [       1897]  FloatElement.class
    │       │   │           │   │   ├── [       1840]  GeneralizingClassElement.class
    │       │   │           │   │   ├── [       1558]  ImprovedRecallResult.class
    │       │   │           │   │   ├── [       2562]  Link.class
    │       │   │           │   │   ├── [       5381]  LinkedGraphModel.class
    │       │   │           │   │   ├── [      10137]  LSA_Model.class
    │       │   │           │   │   ├── [       2547]  Node.class
    │       │   │           │   │   ├── [       1090]  QueueElement.class
    │       │   │           │   │   ├── [        791]  RelationDimensionElement.class
    │       │   │           │   │   ├── [      17745]  SimilarityArrayModel.class
    │       │   │           │   │   ├── [      10865]  SimilarityModel.class
    │       │   │           │   │   ├── [       5788]  SimilarityTreeMapModel.class
    │       │   │           │   │   ├── [       1873]  SimilarPropertyElement.class
    │       │   │           │   │   └── [       1273]  STS_Example.class
    │       │   │           │   └── [       4096]  util
    │       │   │           │       ├── [      19896]  ComplexPredicate.class
    │       │   │           │       ├── [        965]  Contradiction.class
    │       │   │           │       ├── [       9673]  DependencyCheck.class
    │       │   │           │       ├── [       1217]  FlexibleDateParser$1.class
    │       │   │           │       ├── [       1075]  FlexibleDateParser$2.class
    │       │   │           │       ├── [       3092]  FlexibleDateParser.class
    │       │   │           │       ├── [       3994]  LexicalProcess.class
    │       │   │           │       ├── [        530]  MappingEntry.class
    │       │   │           │       ├── [       1662]  OrderedWord.class
    │       │   │           │       ├── [       1013]  StringMarkerElement.class
    │       │   │           │       └── [       2479]  Test.class
    │       │   │           ├── [       4096]  nlp
    │       │   │           │   └── [       4096]  tool
    │       │   │           │       ├── [       7367]  NumberConverter.class
    │       │   │           │       ├── [       2535]  NumberConvertTest.class
    │       │   │           │       ├── [        437]  NumberException.class
    │       │   │           │       └── [       2058]  StringSimilarity.class
    │       │   │           ├── [       4096]  similarity
    │       │   │           │   └── [       4096]  dictionary
    │       │   │           │       └── [      11818]  StanfordTermTokenizer.class
    │       │   │           └── [       4096]  web
    │       │   │               ├── [        773]  Configure.class
    │       │   │               └── [       6763]  StsServlet.class
    │       │   ├── [       4096]  lib
    │       │   │   ├── [     569231]  joda-time.jar
    │       │   │   └── [     312996]  xom.jar
    │       │   ├── [       4096]  src
    │       │   │   ├── [       4096]  com
    │       │   │   │   └── [       4096]  mdimension
    │       │   │   │       └── [       4096]  jchronic
    │       │   │   │           ├── [       7379]  Chronic.java
    │       │   │   │           ├── [       4096]  handlers
    │       │   │   │           │   ├── [        326]  DummyHandler.java
    │       │   │   │           │   ├── [      20793]  Handler.java
    │       │   │   │           │   ├── [        242]  HandlerPattern.java
    │       │   │   │           │   ├── [        407]  HandlerTypePattern.java
    │       │   │   │           │   ├── [        284]  IHandler.java
    │       │   │   │           │   ├── [        849]  MDHandler.java
    │       │   │   │           │   ├── [        441]  ORGRHandler.java
    │       │   │   │           │   ├── [       1029]  ORRHandler.java
    │       │   │   │           │   ├── [        441]  ORSRHandler.java
    │       │   │   │           │   ├── [        549]  PSRHandler.java
    │       │   │   │           │   ├── [       1145]  RdnRmnSdTTzSyHandler.java
    │       │   │   │           │   ├── [        546]  RGRHandler.java
    │       │   │   │           │   ├── [        437]  RHandler.java
    │       │   │   │           │   ├── [        564]  RmnOdHandler.java
    │       │   │   │           │   ├── [        562]  RmnSdHandler.java
    │       │   │   │           │   ├── [       1152]  RmnSdSyHandler.java
    │       │   │   │           │   ├── [        994]  RmnSyHandler.java
    │       │   │   │           │   ├── [        613]  SdRmnSyHandler.java
    │       │   │   │           │   ├── [        610]  SdSmSyHandler.java
    │       │   │   │           │   ├── [        816]  SmSdHandler.java
    │       │   │   │           │   ├── [       1135]  SmSdSyHandler.java
    │       │   │   │           │   ├── [        974]  SmSyHandler.java
    │       │   │   │           │   ├── [        459]  SRPAHandler.java
    │       │   │   │           │   ├── [       1975]  SRPHandler.java
    │       │   │   │           │   ├── [        610]  SySmSdHandler.java
    │       │   │   │           │   └── [        599]  TagPattern.java
    │       │   │   │           ├── [       4096]  numerizer
    │       │   │   │           │   └── [       7904]  Numerizer.java
    │       │   │   │           ├── [       2067]  Options.java
    │       │   │   │           ├── [       4096]  repeaters
    │       │   │   │           │   ├── [       1865]  EnumRepeaterDayPortion.java
    │       │   │   │           │   ├── [        519]  IntegerRepeaterDayPortion.java
    │       │   │   │           │   ├── [       1975]  RepeaterDay.java
    │       │   │   │           │   ├── [       3889]  RepeaterDayName.java
    │       │   │   │           │   ├── [       5841]  RepeaterDayPortion.java
    │       │   │   │           │   ├── [       3437]  RepeaterFortnight.java
    │       │   │   │           │   ├── [       2309]  RepeaterHour.java
    │       │   │   │           │   ├── [       2179]  Repeater.java
    │       │   │   │           │   ├── [       2358]  RepeaterMinute.java
    │       │   │   │           │   ├── [       2165]  RepeaterMonth.java
    │       │   │   │           │   ├── [       5881]  RepeaterMonthName.java
    │       │   │   │           │   ├── [        873]  RepeaterSeason.java
    │       │   │   │           │   ├── [       1021]  RepeaterSeasonName.java
    │       │   │   │           │   ├── [       1383]  RepeaterSecond.java
    │       │   │   │           │   ├── [       7228]  RepeaterTime.java
    │       │   │   │           │   ├── [       2838]  RepeaterUnit.java
    │       │   │   │           │   ├── [       3557]  RepeaterWeekend.java
    │       │   │   │           │   ├── [       3891]  RepeaterWeek.java
    │       │   │   │           │   └── [       2394]  RepeaterYear.java
    │       │   │   │           ├── [       4096]  tags
    │       │   │   │           │   ├── [       1482]  Grabber.java
    │       │   │   │           │   ├── [        674]  OrdinalDay.java
    │       │   │   │           │   ├── [       1058]  Ordinal.java
    │       │   │   │           │   ├── [       1526]  Pointer.java
    │       │   │   │           │   ├── [        833]  ScalarDay.java
    │       │   │   │           │   ├── [       2067]  Scalar.java
    │       │   │   │           │   ├── [        849]  ScalarMonth.java
    │       │   │   │           │   ├── [       1004]  ScalarYear.java
    │       │   │   │           │   ├── [        923]  SeparatorAt.java
    │       │   │   │           │   ├── [        946]  SeparatorComma.java
    │       │   │   │           │   ├── [        919]  SeparatorIn.java
    │       │   │   │           │   ├── [        990]  Separator.java
    │       │   │   │           │   ├── [       1146]  SeparatorSlashOrDash.java
    │       │   │   │           │   ├── [        141]  StringTag.java
    │       │   │   │           │   ├── [        495]  Tag.java
    │       │   │   │           │   └── [       1126]  TimeZone.java
    │       │   │   │           └── [       4096]  utils
    │       │   │   │               ├── [        838]  Range.java
    │       │   │   │               ├── [       1495]  Span.java
    │       │   │   │               ├── [       1251]  StringUtils.java
    │       │   │   │               ├── [        609]  Tick.java
    │       │   │   │               ├── [       2977]  Time.java
    │       │   │   │               └── [       2006]  Token.java
    │       │   │   └── [       4096]  edu
    │       │   │       ├── [       4096]  stanford
    │       │   │       │   └── [       4096]  nlp
    │       │   │       │       ├── [       4096]  classify
    │       │   │       │       │   ├── [       2777]  AbstractLinearClassifierFactory.java
    │       │   │       │       │   ├── [       3163]  AdaptedGaussianPriorObjectiveFunction.java
    │       │   │       │       │   ├── [       3874]  BiasedLogConditionalObjectiveFunction.java
    │       │   │       │       │   ├── [        218]  ClassifierCreator.java
    │       │   │       │       │   ├── [        616]  ClassifierFactory.java
    │       │   │       │       │   ├── [        829]  Classifier.java
    │       │   │       │       │   ├── [       3161]  CrossValidator.java
    │       │   │       │       │   ├── [      24842]  Dataset.java
    │       │   │       │       │   ├── [      15479]  GeneralDataset.java
    │       │   │       │       │   ├── [       8837]  GeneralizedExpectationObjectiveFunction.java
    │       │   │       │       │   ├── [      36327]  LinearClassifierFactory.java
    │       │   │       │       │   ├── [      49837]  LinearClassifier.java
    │       │   │       │       │   ├── [      27602]  LogConditionalObjectiveFunction.java
    │       │   │       │       │   ├── [       9776]  LogPrior.java
    │       │   │       │       │   ├── [       8752]  NBLinearClassifierFactory.java
    │       │   │       │       │   ├── [      11343]  PRCurve.java
    │       │   │       │       │   ├── [        266]  ProbabilisticClassifierCreator.java
    │       │   │       │       │   ├── [        303]  ProbabilisticClassifier.java
    │       │   │       │       │   ├── [        541]  RVFClassifier.java
    │       │   │       │       │   ├── [      32680]  RVFDataset.java
    │       │   │       │       │   ├── [       2267]  SemiSupervisedLogConditionalObjectiveFunction.java
    │       │   │       │       │   ├── [      19055]  SVMLightClassifierFactory.java
    │       │   │       │       │   ├── [       2581]  SVMLightClassifier.java
    │       │   │       │       │   └── [       2649]  WeightedDataset.java
    │       │   │       │       ├── [       4096]  dcoref
    │       │   │       │       │   ├── [      10093]  ACEMentionExtractor.java
    │       │   │       │       │   ├── [      40035]  CoNLL2011DocumentReader.java
    │       │   │       │       │   ├── [       9875]  CoNLLMentionExtractor.java
    │       │   │       │       │   ├── [       7007]  Constants.java
    │       │   │       │       │   ├── [       9115]  CorefChain.java
    │       │   │       │       │   ├── [      16854]  CorefCluster.java
    │       │   │       │       │   ├── [       2869]  CorefCoreAnnotations.java
    │       │   │       │       │   ├── [        337]  CorefMentionFinder.java
    │       │   │       │       │   ├── [        867]  coref.properties
    │       │   │       │       │   ├── [       2062]  CorefScorer.java
    │       │   │       │       │   ├── [      18271]  Dictionaries.java
    │       │   │       │       │   ├── [      28635]  Document.java
    │       │   │       │       │   ├── [      15397]  MentionExtractor.java
    │       │   │       │       │   ├── [      45846]  Mention.java
    │       │   │       │       │   ├── [      12165]  MUCMentionExtractor.java
    │       │   │       │       │   ├── [      22086]  RuleBasedCorefMentionFinder.java
    │       │   │       │       │   ├── [       5772]  ScorerBCubed.java
    │       │   │       │       │   ├── [       2029]  ScorerMUC.java
    │       │   │       │       │   ├── [       1807]  ScorerPairwise.java
    │       │   │       │       │   ├── [        427]  Semantics.java
    │       │   │       │       │   ├── [      49222]  SieveCoreferenceSystem.java
    │       │   │       │       │   ├── [       3356]  SieveOptions.java
    │       │   │       │       │   └── [       4096]  sievepasses
    │       │   │       │       │       ├── [        326]  AliasMatch.java
    │       │   │       │       │       ├── [      20123]  DeterministicCorefSieve.java
    │       │   │       │       │       ├── [        192]  DiscourseMatch.java
    │       │   │       │       │       ├── [        198]  ExactStringMatch.java
    │       │   │       │       │       ├── [        385]  LexicalChainMatch.java
    │       │   │       │       │       ├── [        175]  MarkRole.java
    │       │   │       │       │       ├── [        372]  PreciseConstructs.java
    │       │   │       │       │       ├── [        211]  PronounMatch.java
    │       │   │       │       │       ├── [        220]  RelaxedExactStringMatch.java
    │       │   │       │       │       ├── [        307]  RelaxedHeadMatch.java
    │       │   │       │       │       ├── [        314]  StrictHeadMatch1.java
    │       │   │       │       │       ├── [        270]  StrictHeadMatch2.java
    │       │   │       │       │       ├── [        276]  StrictHeadMatch3.java
    │       │   │       │       │       └── [        354]  StrictHeadMatch4.java
    │       │   │       │       ├── [       4096]  fsm
    │       │   │       │       │   ├── [        193]  AutomatonMinimizer.java
    │       │   │       │       │   ├── [        169]  Block.java
    │       │   │       │       │   ├── [       4722]  DFSA.java
    │       │   │       │       │   ├── [       3547]  DFSAState.java
    │       │   │       │       │   ├── [       1715]  DFSATransition.java
    │       │   │       │       │   ├── [      11386]  FastExactAutomatonMinimizer.java
    │       │   │       │       │   ├── [       5545]  QuasiDeterminizer.java
    │       │   │       │       │   └── [      27706]  TransducerGraph.java
    │       │   │       │       ├── [       4096]  graph
    │       │   │       │       │   ├── [       1403]  ConnectedComponents.java
    │       │   │       │       │   ├── [       2057]  DijkstraShortestPath.java
    │       │   │       │       │   ├── [      13823]  DirectedMultiGraph.java
    │       │   │       │       │   └── [       2756]  Graph.java
    │       │   │       │       ├── [       4096]  ie
    │       │   │       │       │   ├── [      62255]  AbstractSequenceClassifier.java
    │       │   │       │       │   ├── [       8454]  AcquisitionsPrior.java
    │       │   │       │       │   ├── [      13573]  ClassifierCombiner.java
    │       │   │       │       │   ├── [       4096]  crf
    │       │   │       │       │   │   ├── [       7097]  CRFBiasedClassifier.java
    │       │   │       │       │   │   ├── [       4566]  CRFClassifierEvaluator.java
    │       │   │       │       │   │   ├── [      94875]  CRFClassifier.java
    │       │   │       │       │   │   ├── [      23105]  CRFCliqueTree.java
    │       │   │       │       │   │   ├── [       2427]  CRFDatum.java
    │       │   │       │       │   │   ├── [       6242]  CRFFeatureExporter.java
    │       │   │       │       │   │   ├── [       1890]  CRFLabel.java
    │       │   │       │       │   │   ├── [      19526]  CRFLogConditionalObjectiveFloatFunction.java
    │       │   │       │       │   │   ├── [      32582]  CRFLogConditionalObjectiveFunction.java
    │       │   │       │       │   │   ├── [      19202]  FactorTable.java
    │       │   │       │       │   │   └── [       9973]  FloatFactorTable.java
    │       │   │       │       │   ├── [      10055]  EmpiricalNERPrior.java
    │       │   │       │       │   ├── [      17011]  EntityCachingAbstractSequencePrior.java
    │       │   │       │       │   ├── [       4096]  machinereading
    │       │   │       │       │   │   ├── [       4096]  common
    │       │   │       │       │   │   │   ├── [       4093]  DomReader.java
    │       │   │       │       │   │   │   ├── [       2038]  NoPunctuationHeadFinder.java
    │       │   │       │       │   │   │   ├── [       3949]  SimpleTokenize.java
    │       │   │       │       │   │   │   └── [       4986]  StringDictionary.java
    │       │   │       │       │   │   ├── [       4096]  domains
    │       │   │       │       │   │   │   └── [       4096]  ace
    │       │   │       │       │   │   │       ├── [      20545]  AceReader.java
    │       │   │       │       │   │   │       └── [       4096]  reader
    │       │   │       │       │   │   │           ├── [       5209]  AceCharSeq.java
    │       │   │       │       │   │   │           ├── [      28075]  AceDocument.java
    │       │   │       │       │   │   │           ├── [       7814]  AceDomReader.java
    │       │   │       │       │   │   │           ├── [        458]  AceElement.java
    │       │   │       │       │   │   │           ├── [       1563]  AceEntity.java
    │       │   │       │       │   │   │           ├── [       4550]  AceEntityMention.java
    │       │   │       │       │   │   │           ├── [       1868]  AceEvent.java
    │       │   │       │       │   │   │           ├── [        254]  AceEventMentionArgument.java
    │       │   │       │       │   │   │           ├── [       3266]  AceEventMention.java
    │       │   │       │       │   │   │           ├── [       1419]  AceMentionArgument.java
    │       │   │       │       │   │   │           ├── [        428]  AceMention.java
    │       │   │       │       │   │   │           ├── [       2161]  AceRelation.java
    │       │   │       │       │   │   │           ├── [        263]  AceRelationMentionArgument.java
    │       │   │       │       │   │   │           ├── [       3105]  AceRelationMention.java
    │       │   │       │       │   │   │           ├── [       4338]  AceSentenceSegmenter.java
    │       │   │       │       │   │   │           ├── [      12666]  AceToken.java
    │       │   │       │       │   │   │           ├── [        228]  MatchException.java
    │       │   │       │       │   │   │           └── [      29727]  RobustTokenizer.java
    │       │   │       │       │   │   ├── [      21014]  GenericDataSetReader.java
    │       │   │       │       │   │   ├── [       1235]  RelationMentionFactory.java
    │       │   │       │       │   │   └── [       4096]  structure
    │       │   │       │       │   │       ├── [      21149]  AnnotationUtils.java
    │       │   │       │       │   │       ├── [      10354]  EntityMention.java
    │       │   │       │       │   │       ├── [       7398]  EventMention.java
    │       │   │       │       │   │       ├── [       8795]  ExtractionObject.java
    │       │   │       │       │   │       ├── [       3117]  MachineReadingAnnotations.java
    │       │   │       │       │   │       ├── [       9812]  RelationMention.java
    │       │   │       │       │   │       └── [       3238]  Span.java
    │       │   │       │       │   ├── [       4096]  ner
    │       │   │       │       │   │   └── [      60484]  CMMClassifier.java
    │       │   │       │       │   ├── [       6596]  NERClassifierCombiner.java
    │       │   │       │       │   ├── [      97951]  NERFeatureFactory.java
    │       │   │       │       │   ├── [      35854]  NumberNormalizer.java
    │       │   │       │       │   ├── [       4096]  pascal
    │       │   │       │       │   │   ├── [      22621]  AcronymModel.java
    │       │   │       │       │   │   ├── [       6217]  AlignmentFactory.java
    │       │   │       │       │   │   ├── [       2786]  Alignment.java
    │       │   │       │       │   │   ├── [        904]  CliqueTemplates.java
    │       │   │       │       │   │   ├── [       1272]  DateTemplate.java
    │       │   │       │       │   │   ├── [      72168]  DefaultTeXHyphenData.java
    │       │   │       │       │   │   ├── [       1768]  InfoTemplate.java
    │       │   │       │       │   │   ├── [      38907]  ISODateInstance.java
    │       │   │       │       │   │   ├── [       7600]  PascalTemplate.java
    │       │   │       │       │   │   ├── [       2036]  Prior.java
    │       │   │       │       │   │   ├── [        332]  RelationalModel.java
    │       │   │       │       │   │   └── [       5436]  TeXHyphenator.java
    │       │   │       │       │   ├── [      57729]  QuantifiableEntityNormalizer.java
    │       │   │       │       │   ├── [       4096]  regexp
    │       │   │       │       │   │   ├── [      36011]  NumberSequenceClassifier.java
    │       │   │       │       │   │   └── [      10961]  RegexNERSequenceClassifier.java
    │       │   │       │       │   ├── [       5503]  SeminarsPrior.java
    │       │   │       │       │   └── [       1769]  UniformPrior.java
    │       │   │       │       ├── [       4096]  international
    │       │   │       │       │   ├── [       4096]  arabic
    │       │   │       │       │   │   ├── [      10219]  ArabicMorphoFeatureSpecification.java
    │       │   │       │       │   │   └── [       4096]  process
    │       │   │       │       │   │       ├── [      41446]  ArabicLexer.java
    │       │   │       │       │   │       └── [       6888]  ArabicTokenizer.java
    │       │   │       │       │   ├── [       4096]  french
    │       │   │       │       │   │   ├── [       6893]  FrenchMorphoFeatureSpecification.java
    │       │   │       │       │   │   └── [       3469]  FrenchUnknownWordSignatures.java
    │       │   │       │       │   ├── [       1812]  Languages.java
    │       │   │       │       │   └── [       4096]  morph
    │       │   │       │       │       ├── [       3690]  MorphoFeatures.java
    │       │   │       │       │       └── [       1305]  MorphoFeatureSpecification.java
    │       │   │       │       ├── [       4096]  io
    │       │   │       │       │   ├── [       1970]  BZip2PipedOutputStream.java
    │       │   │       │       │   ├── [       3537]  EncodingFileReader.java
    │       │   │       │       │   ├── [       6749]  EncodingFileWriter.java
    │       │   │       │       │   ├── [       3394]  EncodingPrintWriter.java
    │       │   │       │       │   ├── [       2081]  ExtensionFileFilter.java
    │       │   │       │       │   ├── [      16843]  FileSequentialCollection.java
    │       │   │       │       │   ├── [        707]  InDataStreamFile.java
    │       │   │       │       │   ├── [      39513]  IOUtils.java
    │       │   │       │       │   ├── [       1610]  Lexer.java
    │       │   │       │       │   ├── [       2215]  NumberRangeFileFilter.java
    │       │   │       │       │   ├── [       5374]  NumberRangesFileFilter.java
    │       │   │       │       │   ├── [        679]  OutDataStreamFile.java
    │       │   │       │       │   ├── [        644]  PrintFile.java
    │       │   │       │       │   ├── [       5023]  ReaderInputStream.java
    │       │   │       │       │   ├── [        969]  RegExFileFilter.java
    │       │   │       │       │   ├── [       1111]  RuntimeIOException.java
    │       │   │       │       │   └── [        536]  StringOutputStream.java
    │       │   │       │       ├── [       4096]  ling
    │       │   │       │       │   ├── [      11859]  AnnotationLookup.java
    │       │   │       │       │   ├── [       3740]  BasicDatum.java
    │       │   │       │       │   ├── [      14964]  BasicDocument.java
    │       │   │       │       │   ├── [       2247]  CategoryWordTagFactory.java
    │       │   │       │       │   ├── [       4449]  CategoryWordTag.java
    │       │   │       │       │   ├── [        876]  CoreAnnotation.java
    │       │   │       │       │   ├── [      42453]  CoreAnnotations.java
    │       │   │       │       │   ├── [      16110]  CoreLabel.java
    │       │   │       │       │   ├── [       7503]  CyclicCoreLabel.java
    │       │   │       │       │   ├── [        677]  Datum.java
    │       │   │       │       │   ├── [       1237]  Document.java
    │       │   │       │       │   ├── [       8079]  DocumentReader.java
    │       │   │       │       │   ├── [        399]  Featurizable.java
    │       │   │       │       │   ├── [        544]  HasCategory.java
    │       │   │       │       │   ├── [       1032]  HasContext.java
    │       │   │       │       │   ├── [        237]  HasIndex.java
    │       │   │       │       │   ├── [       1057]  HasOffset.java
    │       │   │       │       │   ├── [        503]  HasTag.java
    │       │   │       │       │   ├── [        550]  HasWord.java
    │       │   │       │       │   ├── [       9962]  IndexedWord.java
    │       │   │       │       │   ├── [        976]  Labeled.java
    │       │   │       │       │   ├── [       1970]  LabeledWord.java
    │       │   │       │       │   ├── [       2267]  LabelFactory.java
    │       │   │       │       │   ├── [       2709]  Label.java
    │       │   │       │       │   ├── [       3580]  RVFDatum.java
    │       │   │       │       │   ├── [       7603]  Sentence.java
    │       │   │       │       │   ├── [       1883]  StringLabelFactory.java
    │       │   │       │       │   ├── [       3458]  StringLabel.java
    │       │   │       │       │   ├── [       3105]  TaggedWordFactory.java
    │       │   │       │       │   ├── [       3520]  TaggedWord.java
    │       │   │       │       │   ├── [       3240]  Tag.java
    │       │   │       │       │   ├── [       4096]  tokensregex
    │       │   │       │       │   │   ├── [       4780]  BasicSequenceMatchResult.java
    │       │   │       │       │   │   ├── [       8811]  CoreMapExpressionExtractor.java
    │       │   │       │       │   │   ├── [      10787]  CoreMapNodePattern.java
    │       │   │       │       │   │   ├── [       4581]  CoreMapSequenceMatchAction.java
    │       │   │       │       │   │   ├── [       3612]  CoreMapSequenceMatcher.java
    │       │   │       │       │   │   ├── [      13717]  MatchedExpression.java
    │       │   │       │       │   │   ├── [       1787]  MultiCoreMapNodePattern.java
    │       │   │       │       │   │   ├── [       2570]  MultiNodePattern.java
    │       │   │       │       │   │   ├── [       1756]  NodePattern.java
    │       │   │       │       │   │   ├── [       6191]  ParseException.java
    │       │   │       │       │   │   ├── [       2938]  SequenceMatchAction.java
    │       │   │       │       │   │   ├── [      36189]  SequenceMatcher.java
    │       │   │       │       │   │   ├── [       4014]  SequenceMatchResult.java
    │       │   │       │       │   │   ├── [      29441]  SequenceMatchRules.java
    │       │   │       │       │   │   ├── [      47439]  SequencePattern.java
    │       │   │       │       │   │   ├── [      11708]  SimpleCharStream.java
    │       │   │       │       │   │   ├── [       4093]  Token.java
    │       │   │       │       │   │   ├── [       4436]  TokenMgrError.java
    │       │   │       │       │   │   ├── [        943]  TokenSequenceMatcher.java
    │       │   │       │       │   │   ├── [       1683]  TokenSequenceParserConstants.java
    │       │   │       │       │   │   ├── [      55616]  TokenSequenceParser.java
    │       │   │       │       │   │   ├── [      28429]  TokenSequenceParserTokenManager.java
    │       │   │       │       │   │   └── [       6523]  TokenSequencePattern.java
    │       │   │       │       │   ├── [       3408]  ValueLabel.java
    │       │   │       │       │   ├── [       1656]  WordFactory.java
    │       │   │       │       │   ├── [       2137]  Word.java
    │       │   │       │       │   ├── [       3671]  WordLemmaTagFactory.java
    │       │   │       │       │   ├── [       7001]  WordLemmaTag.java
    │       │   │       │       │   ├── [       3342]  WordTagFactory.java
    │       │   │       │       │   └── [       6473]  WordTag.java
    │       │   │       │       ├── [       4096]  math
    │       │   │       │       │   ├── [       4092]  ADMath.java
    │       │   │       │       │   ├── [      55656]  ArrayMath.java
    │       │   │       │       │   ├── [       2370]  DoubleAD.java
    │       │   │       │       │   └── [      22015]  SloppyMath.java
    │       │   │       │       ├── [       4096]  maxent
    │       │   │       │       │   ├── [      10808]  CGRunner.java
    │       │   │       │       │   ├── [      22627]  Convert.java
    │       │   │       │       │   ├── [        441]  DataGeneric.java
    │       │   │       │       │   ├── [      12308]  Experiments.java
    │       │   │       │       │   ├── [       7386]  Feature.java
    │       │   │       │       │   ├── [       4130]  Features.java
    │       │   │       │       │   ├── [       4096]  iis
    │       │   │       │       │   │   └── [      36331]  LambdaSolve.java
    │       │   │       │       │   └── [       2639]  Problem.java
    │       │   │       │       ├── [       4096]  objectbank
    │       │   │       │       │   ├── [       4133]  DelimitRegExIterator.java
    │       │   │       │       │   ├── [        338]  IdentityFunction.java
    │       │   │       │       │   ├── [        520]  IteratorFromReaderFactory.java
    │       │   │       │       │   ├── [       3231]  LineIterator.java
    │       │   │       │       │   ├── [      14062]  ObjectBank.java
    │       │   │       │       │   ├── [       7965]  ReaderIteratorFactory.java
    │       │   │       │       │   ├── [       2724]  ResettableReaderIteratorFactory.java
    │       │   │       │       │   ├── [        969]  TokenizerFactory.java
    │       │   │       │       │   └── [       9229]  XMLBeginEndIterator.java
    │       │   │       │       ├── [       4096]  optimization
    │       │   │       │       │   ├── [       1335]  AbstractCachingDiffFloatFunction.java
    │       │   │       │       │   ├── [       1481]  AbstractCachingDiffFunction.java
    │       │   │       │       │   ├── [      17329]  AbstractStochasticCachingDiffFunction.java
    │       │   │       │       │   ├── [       2532]  AbstractStochasticCachingDiffUpdateFunction.java
    │       │   │       │       │   ├── [      17627]  CGMinimizer.java
    │       │   │       │       │   ├── [       1743]  CmdEvaluator.java
    │       │   │       │       │   ├── [        650]  DiffFloatFunction.java
    │       │   │       │       │   ├── [        642]  DiffFunction.java
    │       │   │       │       │   ├── [        140]  Evaluator.java
    │       │   │       │       │   ├── [        587]  FloatFunction.java
    │       │   │       │       │   ├── [        584]  Function.java
    │       │   │       │       │   ├── [       7486]  GoldenSectionLineSearch.java
    │       │   │       │       │   ├── [        236]  HasEvaluators.java
    │       │   │       │       │   ├── [        407]  HasFloatInitial.java
    │       │   │       │       │   ├── [        403]  HasInitial.java
    │       │   │       │       │   ├── [       1863]  HybridMinimizer.java
    │       │   │       │       │   ├── [        481]  LineSearcher.java
    │       │   │       │       │   ├── [        785]  MemoryEvaluator.java
    │       │   │       │       │   ├── [       1205]  Minimizer.java
    │       │   │       │       │   ├── [      70734]  QNMinimizer.java
    │       │   │       │       │   ├── [       1273]  ResultStoringFloatMonitor.java
    │       │   │       │       │   ├── [       1262]  ResultStoringMonitor.java
    │       │   │       │       │   ├── [      10943]  ScaledSGDMinimizer.java
    │       │   │       │       │   ├── [       4305]  SGDMinimizer.java
    │       │   │       │       │   ├── [       3963]  SGDToQNMinimizer.java
    │       │   │       │       │   ├── [       6510]  SMDMinimizer.java
    │       │   │       │       │   ├── [       6040]  SQNMinimizer.java
    │       │   │       │       │   ├── [       2239]  StochasticCalculateMethods.java
    │       │   │       │       │   ├── [      23407]  StochasticDiffFunctionTester.java
    │       │   │       │       │   ├── [      11557]  StochasticInPlaceMinimizer.java
    │       │   │       │       │   └── [      17653]  StochasticMinimizer.java
    │       │   │       │       ├── [       4096]  parser
    │       │   │       │       │   ├── [       4096]  charniak
    │       │   │       │       │   │   ├── [       6615]  CharniakParser.java
    │       │   │       │       │   │   └── [       7922]  CharniakScoredParsesReaderWriter.java
    │       │   │       │       │   ├── [       2774]  KBestViterbiParser.java
    │       │   │       │       │   ├── [       4096]  lexparser
    │       │   │       │       │   │   ├── [       7715]  AbstractDependencyGrammar.java
    │       │   │       │       │   │   ├── [      21671]  AbstractTreebankParserParams.java
    │       │   │       │       │   │   ├── [       2741]  AbstractTreeExtractor.java
    │       │   │       │       │   │   ├── [      43946]  ArabicTreebankParserParams.java
    │       │   │       │       │   │   ├── [      35017]  BaseLexicon.java
    │       │   │       │       │   │   ├── [      13743]  BaseUnknownWordModel.java
    │       │   │       │       │   │   ├── [        570]  BasicCategoryTagProjection.java
    │       │   │       │       │   │   ├── [      37173]  BiLexPCFGParser.java
    │       │   │       │       │   │   ├── [       3046]  BinaryGrammarExtractor.java
    │       │   │       │       │   │   ├── [       8568]  BinaryGrammar.java
    │       │   │       │       │   │   ├── [       3793]  BinaryRule.java
    │       │   │       │       │   │   ├── [       1026]  BoundaryRemover.java
    │       │   │       │       │   │   ├── [      30021]  ChineseCharacterBasedLexicon.java
    │       │   │       │       │   │   ├── [      26192]  ChineseLexiconAndWordSegmenter.java
    │       │   │       │       │   │   ├── [       2976]  ChineseLexicon.java
    │       │   │       │       │   │   ├── [      14651]  ChineseSimWordAvgDepGrammar.java
    │       │   │       │       │   │   ├── [      46686]  ChineseTreebankParserParams.java
    │       │   │       │       │   │   ├── [       4293]  CNFTransformers.java
    │       │   │       │       │   │   ├── [       3552]  CollinsPuncTransformer.java
    │       │   │       │       │   │   ├── [       1951]  Debinarizer.java
    │       │   │       │       │   │   ├── [       3879]  DependencyGrammar.java
    │       │   │       │       │   │   ├── [       1157]  Edge.java
    │       │   │       │       │   │   ├── [      94698]  EnglishTreebankParserParams.java
    │       │   │       │       │   │   ├── [      24554]  EnglishUnknownWordModel.java
    │       │   │       │       │   │   ├── [       2111]  EvalbFormatWriter.java
    │       │   │       │       │   │   ├── [       2239]  ExactGrammarCompactor.java
    │       │   │       │       │   │   ├── [      35662]  ExhaustiveDependencyParser.java
    │       │   │       │       │   │   ├── [      85365]  ExhaustivePCFGParser.java
    │       │   │       │       │   │   ├── [        423]  Extractor.java
    │       │   │       │       │   │   ├── [       3610]  FactoredLexicon.java
    │       │   │       │       │   │   ├── [      23788]  FactoredParser.java
    │       │   │       │       │   │   ├── [       7606]  FastFactoredParser.java
    │       │   │       │       │   │   ├── [      39296]  FrenchTreebankParserParams.java
    │       │   │       │       │   │   ├── [       1594]  GermanUnknownWordModel.java
    │       │   │       │       │   │   ├── [      15106]  GrammarCompactor.java
    │       │   │       │       │   │   ├── [        390]  GrammarProjection.java
    │       │   │       │       │   │   ├── [       2763]  HebrewTreebankParserParams.java
    │       │   │       │       │   │   ├── [       7825]  HookChart.java
    │       │   │       │       │   │   ├── [       1743]  Hook.java
    │       │   │       │       │   │   ├── [      18891]  HTKLatticeReader.java
    │       │   │       │       │   │   ├── [       2331]  IntDependency.java
    │       │   │       │       │   │   ├── [        392]  Interner.java
    │       │   │       │       │   │   ├── [       5232]  IntTaggedWord.java
    │       │   │       │       │   │   ├── [       1112]  Item.java
    │       │   │       │       │   │   ├── [      18821]  IterativeCKYPCFGParser.java
    │       │   │       │       │   │   ├── [       1087]  LatticeEdge.java
    │       │   │       │       │   │   ├── [       2299]  Lattice.java
    │       │   │       │       │   │   ├── [        175]  LatticeScorer.java
    │       │   │       │       │   │   ├── [      66902]  LexicalizedParser.java
    │       │   │       │       │   │   ├── [      51506]  LexicalizedParserQuery.java
    │       │   │       │       │   │   ├── [       4290]  Lexicon.java
    │       │   │       │       │   │   ├── [       4841]  LinearGrammarSmoother.java
    │       │   │       │       │   │   ├── [       2458]  MLEDependencyGrammarExtractor.java
    │       │   │       │       │   │   ├── [      37415]  MLEDependencyGrammar.java
    │       │   │       │       │   │   ├── [       2297]  NegraPennCollinizer.java
    │       │   │       │       │   │   ├── [      11496]  NegraPennTreebankParserParams.java
    │       │   │       │       │   │   ├── [       3259]  NodePruner.java
    │       │   │       │       │   │   ├── [        550]  NullGrammarProjection.java
    │       │   │       │       │   │   ├── [      43374]  Options.java
    │       │   │       │       │   │   ├── [       5682]  OutsideRuleFilter.java
    │       │   │       │       │   │   ├── [      21731]  ParentAnnotationStats.java
    │       │   │       │       │   │   ├── [        850]  ParserAnnotations.java
    │       │   │       │       │   │   ├── [       1842]  ParserConstraint.java
    │       │   │       │       │   │   ├── [       3828]  PostSplitter.java
    │       │   │       │       │   │   ├── [       1510]  ProjectionScorer.java
    │       │   │       │       │   │   ├── [       3022]  RandomWalk.java
    │       │   │       │       │   │   ├── [        321]  Rule.java
    │       │   │       │       │   │   ├── [        415]  Scorer.java
    │       │   │       │       │   │   ├── [      11272]  SisterAnnotationStats.java
    │       │   │       │       │   │   ├── [        467]  TagProjection.java
    │       │   │       │       │   │   ├── [       9945]  TestOptions.java
    │       │   │       │       │   │   ├── [       1113]  TestTagProjection.java
    │       │   │       │       │   │   ├── [       9023]  TrainOptions.java
    │       │   │       │       │   │   ├── [      10521]  TreeAnnotatorAndBinarizer.java
    │       │   │       │       │   │   ├── [       9911]  TreeAnnotator.java
    │       │   │       │       │   │   ├── [       3697]  TreebankAnnotator.java
    │       │   │       │       │   │   ├── [       8454]  TreebankLangParserParams.java
    │       │   │       │       │   │   ├── [      25206]  TreeBinarizer.java
    │       │   │       │       │   │   ├── [       2768]  TreeCollinizer.java
    │       │   │       │       │   │   ├── [        913]  TwinScorer.java
    │       │   │       │       │   │   ├── [      11227]  UnaryGrammar.java
    │       │   │       │       │   │   ├── [       3091]  UnaryRule.java
    │       │   │       │       │   │   └── [       3629]  UnknownWordModel.java
    │       │   │       │       │   ├── [       4096]  metrics
    │       │   │       │       │   │   ├── [      11888]  AbstractEval.java
    │       │   │       │       │   │   ├── [       6343]  EvalbByCat.java
    │       │   │       │       │   │   ├── [      13051]  Evalb.java
    │       │   │       │       │   │   ├── [      12685]  LeafAncestorEval.java
    │       │   │       │       │   │   ├── [      13484]  TaggingEval.java
    │       │   │       │       │   │   └── [       8387]  UnlabeledAttachmentEval.java
    │       │   │       │       │   ├── [       1364]  Parser.java
    │       │   │       │       │   ├── [       4096]  tools
    │       │   │       │       │   │   └── [       3353]  PunctEquivalenceClasser.java
    │       │   │       │       │   ├── [        525]  ViterbiParser.java
    │       │   │       │       │   └── [        932]  ViterbiParserWithOptions.java
    │       │   │       │       ├── [       4096]  pipeline
    │       │   │       │       │   ├── [       2424]  Annotation.java
    │       │   │       │       │   ├── [       5153]  AnnotationPipeline.java
    │       │   │       │       │   ├── [        390]  AnnotationSerializer.java
    │       │   │       │       │   ├── [       1224]  Annotator.java
    │       │   │       │       │   ├── [       2208]  AnnotatorPool.java
    │       │   │       │       │   ├── [       2174]  CharniakParserAnnotator.java
    │       │   │       │       │   ├── [      40514]  ChunkAnnotationUtils.java
    │       │   │       │       │   ├── [      10800]  CleanXmlAnnotator.java
    │       │   │       │       │   ├── [       2074]  CoreMapAggregator.java
    │       │   │       │       │   ├── [      10435]  CoreMapAttributeAggregator.java
    │       │   │       │       │   ├── [      18294]  CustomAnnotationSerializer.java
    │       │   │       │       │   ├── [       3103]  DefaultPaths.java
    │       │   │       │       │   ├── [       8051]  DeterministicCorefAnnotator.java
    │       │   │       │       │   ├── [       2082]  GenderAnnotator.java
    │       │   │       │       │   ├── [      10808]  LabeledChunkIdentifier.java
    │       │   │       │       │   ├── [       3468]  MorphaAnnotator.java
    │       │   │       │       │   ├── [       4076]  NERCombinerAnnotator.java
    │       │   │       │       │   ├── [       6133]  ParserAnnotator.java
    │       │   │       │       │   ├── [       4788]  ParserAnnotatorUtils.java
    │       │   │       │       │   ├── [       5600]  POSTaggerAnnotator.java
    │       │   │       │       │   ├── [       1332]  PTBTokenizerAnnotator.java
    │       │   │       │       │   ├── [       4372]  RegexNERAnnotator.java
    │       │   │       │       │   ├── [       2377]  Requirement.java
    │       │   │       │       │   ├── [      60129]  StanfordCoreNLP.java
    │       │   │       │       │   ├── [       3533]  StanfordCoreNLP.properties
    │       │   │       │       │   ├── [       2411]  TokenizerAnnotator.java
    │       │   │       │       │   ├── [       5057]  TrueCaseAnnotator.java
    │       │   │       │       │   ├── [       1501]  WhitespaceTokenizerAnnotator.java
    │       │   │       │       │   └── [       4565]  WordsToSentencesAnnotator.java
    │       │   │       │       ├── [       4096]  process
    │       │   │       │       │   ├── [       1364]  AbstractListProcessor.java
    │       │   │       │       │   ├── [       2280]  AbstractTokenizer.java
    │       │   │       │       │   ├── [      11246]  Americanize.java
    │       │   │       │       │   ├── [       2983]  CoreLabelTokenFactory.java
    │       │   │       │       │   ├── [        509]  CoreTokenFactory.java
    │       │   │       │       │   ├── [      15926]  DocumentPreprocessor.java
    │       │   │       │       │   ├── [        793]  DocumentProcessor.java
    │       │   │       │       │   ├── [      13610]  JFlexDummyLexer.java
    │       │   │       │       │   ├── [        701]  LexedTokenFactory.java
    │       │   │       │       │   ├── [       1959]  LexerTokenizer.java
    │       │   │       │       │   ├── [        617]  ListProcessor.java
    │       │   │       │       │   ├── [    3807278]  Morpha.java
    │       │   │       │       │   ├── [       9673]  Morphology.java
    │       │   │       │       │   ├── [      49997]  PTB2TextLexer.java
    │       │   │       │       │   ├── [       6806]  PTBEscapingProcessor.java
    │       │   │       │       │   ├── [     626039]  PTBLexer.java
    │       │   │       │       │   ├── [      30999]  PTBTokenizer.java
    │       │   │       │       │   ├── [        488]  SerializableFunction.java
    │       │   │       │       │   ├── [       4520]  StripTagsProcessor.java
    │       │   │       │       │   ├── [       2538]  TokenizerAdapter.java
    │       │   │       │       │   ├── [       1633]  Tokenizer.java
    │       │   │       │       │   ├── [      14452]  TransformXML.java
    │       │   │       │       │   ├── [      15661]  WhitespaceLexer.java
    │       │   │       │       │   ├── [       7768]  WhitespaceTokenizer.java
    │       │   │       │       │   ├── [        482]  WordSegmenter.java
    │       │   │       │       │   ├── [       2222]  WordSegmentingTokenizer.java
    │       │   │       │       │   ├── [      29645]  WordShapeClassifier.java
    │       │   │       │       │   ├── [        415]  WordTokenFactory.java
    │       │   │       │       │   └── [      11704]  WordToSentenceProcessor.java
    │       │   │       │       ├── [       4096]  sequences
    │       │   │       │       │   ├── [      14880]  BeamBestSequenceFinder.java
    │       │   │       │       │   ├── [        367]  BestSequenceFinder.java
    │       │   │       │       │   ├── [       5572]  Clique.java
    │       │   │       │       │   ├── [       3231]  ColumnDocumentReaderAndWriter.java
    │       │   │       │       │   ├── [      14353]  CoNLLDocumentReaderAndWriter.java
    │       │   │       │       │   ├── [       1049]  CoolingSchedule.java
    │       │   │       │       │   ├── [       1423]  DocumentReaderAndWriter.java
    │       │   │       │       │   ├── [      12941]  ExactBestSequenceFinder.java
    │       │   │       │       │   ├── [       1411]  FactoredSequenceListener.java
    │       │   │       │       │   ├── [       4737]  FactoredSequenceModel.java
    │       │   │       │       │   ├── [       4764]  FeatureFactory.java
    │       │   │       │       │   ├── [       8505]  KBestSequenceFinder.java
    │       │   │       │       │   ├── [        603]  LatticeWriter.java
    │       │   │       │       │   ├── [       9522]  ObjectBankWrapper.java
    │       │   │       │       │   ├── [      17774]  PlainTextDocumentReaderAndWriter.java
    │       │   │       │       │   ├── [      87862]  SeqClassifierFlags.java
    │       │   │       │       │   ├── [      11209]  SequenceGibbsSampler.java
    │       │   │       │       │   ├── [        644]  SequenceListener.java
    │       │   │       │       │   ├── [       2373]  SequenceModel.java
    │       │   │       │       │   ├── [       2880]  SequenceSampler.java
    │       │   │       │       │   └── [       5379]  ViterbiSearchGraphBuilder.java
    │       │   │       │       ├── [       4096]  stats
    │       │   │       │       │   ├── [       1085]  AbstractCounter.java
    │       │   │       │       │   ├── [       3874]  AccuracyStats.java
    │       │   │       │       │   ├── [      16739]  ClassicCounter.java
    │       │   │       │       │   ├── [       9748]  Counter.java
    │       │   │       │       │   ├── [      84637]  Counters.java
    │       │   │       │       │   ├── [      31165]  Distribution.java
    │       │   │       │       │   ├── [        439]  EquivalenceClasser.java
    │       │   │       │       │   ├── [      21964]  EquivalenceClassEval.java
    │       │   │       │       │   ├── [      29172]  GeneralizedCounter.java
    │       │   │       │       │   ├── [      23054]  IntCounter.java
    │       │   │       │       │   ├── [       5917]  MultiClassAccuracyStats.java
    │       │   │       │       │   ├── [       6356]  MultiClassChunkEvalStats.java
    │       │   │       │       │   ├── [      10146]  MultiClassPrecisionRecallExtendedStats.java
    │       │   │       │       │   ├── [       7702]  MultiClassPrecisionRecallStats.java
    │       │   │       │       │   ├── [        433]  ProbabilityDistribution.java
    │       │   │       │       │   ├── [        684]  Sampler.java
    │       │   │       │       │   ├── [        351]  Scorer.java
    │       │   │       │       │   ├── [       8907]  SimpleGoodTuring.java
    │       │   │       │       │   ├── [       2378]  TwoDimensionalCounterInterface.java
    │       │   │       │       │   └── [      11887]  TwoDimensionalCounter.java
    │       │   │       │       ├── [       4096]  tagger
    │       │   │       │       │   ├── [       4096]  common
    │       │   │       │       │   │   └── [        369]  TaggerConstants.java
    │       │   │       │       │   ├── [       4096]  io
    │       │   │       │       │   │   ├── [        272]  TaggedFileReader.java
    │       │   │       │       │   │   ├── [       7377]  TaggedFileRecord.java
    │       │   │       │       │   │   ├── [       2380]  TextTaggedFileReader.java
    │       │   │       │       │   │   ├── [       2218]  TreeTaggedFileReader.java
    │       │   │       │       │   │   └── [       2900]  TSVTaggedFileReader.java
    │       │   │       │       │   └── [       4096]  maxent
    │       │   │       │       │       ├── [       5352]  AmbiguityClasses.java
    │       │   │       │       │       ├── [       3885]  AmbiguityClass.java
    │       │   │       │       │       ├── [       2040]  ASBCunkDict.java
    │       │   │       │       │       ├── [       2672]  CountWrapper.java
    │       │   │       │       │       ├── [       2374]  CtbDict.java
    │       │   │       │       │       ├── [       2191]  CTBunkDict.java
    │       │   │       │       │       ├── [        779]  DataWordTag.java
    │       │   │       │       │       ├── [       1070]  DictionaryExtractor.java
    │       │   │       │       │       ├── [       9325]  Dictionary.java
    │       │   │       │       │       ├── [       2887]  ExtractorDistsim.java
    │       │   │       │       │       ├── [      26585]  ExtractorFrames.java
    │       │   │       │       │       ├── [      45509]  ExtractorFramesRare.java
    │       │   │       │       │       ├── [       9028]  Extractor.java
    │       │   │       │       │       ├── [       5097]  Extractors.java
    │       │   │       │       │       ├── [       2662]  ExtractorVerbalVBNZero.java
    │       │   │       │       │       ├── [       3401]  FeatureKey.java
    │       │   │       │       │       ├── [       2876]  History.java
    │       │   │       │       │       ├── [       1011]  HistoryTable.java
    │       │   │       │       │       ├── [      10066]  LambdaSolveTagger.java
    │       │   │       │       │       ├── [       6039]  MaxentTaggerGUI.java
    │       │   │       │       │       ├── [      69358]  MaxentTagger.java
    │       │   │       │       │       ├── [       3165]  PairsHolder.java
    │       │   │       │       │       ├── [       5009]  ReadDataTagged.java
    │       │   │       │       │       ├── [       4178]  TagCount.java
    │       │   │       │       │       ├── [      34329]  TaggerConfig.java
    │       │   │       │       │       ├── [      14945]  TaggerExperiments.java
    │       │   │       │       │       ├── [       3465]  TaggerFeature.java
    │       │   │       │       │       ├── [       2637]  TaggerFeatures.java
    │       │   │       │       │       ├── [       6115]  TemplateHash.java
    │       │   │       │       │       ├── [       7061]  TestClassifier.java
    │       │   │       │       │       ├── [      23967]  TestSentence.java
    │       │   │       │       │       └── [      12968]  TTags.java
    │       │   │       │       ├── [       4096]  time
    │       │   │       │       │   ├── [      18027]  DateTimeUtils.java
    │       │   │       │       │   ├── [      37129]  JodaTimeUtils.java
    │       │   │       │       │   ├── [       1812]  Options.java
    │       │   │       │       │   ├── [     128968]  SUTime.java
    │       │   │       │       │   ├── [       1123]  TimeAnnotations.java
    │       │   │       │       │   ├── [      32333]  TimeExpressionExtractor.java
    │       │   │       │       │   ├── [       4751]  TimeExpression.java
    │       │   │       │       │   ├── [      98331]  TimeExpressionPatterns.java
    │       │   │       │       │   └── [      17295]  Timex.java
    │       │   │       │       ├── [       4096]  trees
    │       │   │       │       │   ├── [      13101]  AbstractCollinsHeadFinder.java
    │       │   │       │       │   ├── [      17665]  AbstractTreebankLanguagePack.java
    │       │   │       │       │   ├── [       5082]  BobChrisTreeNormalizer.java
    │       │   │       │       │   ├── [       5587]  CollinsHeadFinder.java
    │       │   │       │       │   ├── [      14455]  CollocationFinder.java
    │       │   │       │       │   ├── [       1403]  CompositeTreebank.java
    │       │   │       │       │   ├── [        862]  CompositeTreeTransformer.java
    │       │   │       │       │   ├── [        757]  ConstituentFactory.java
    │       │   │       │       │   ├── [       7885]  Constituent.java
    │       │   │       │       │   ├── [      15661]  CoordinationTransformer.java
    │       │   │       │       │   ├── [       6183]  Dependencies.java
    │       │   │       │       │   ├── [        349]  DependencyFactory.java
    │       │   │       │       │   ├── [       1930]  Dependency.java
    │       │   │       │       │   ├── [        212]  DependencyPrinter.java
    │       │   │       │       │   ├── [        213]  DependencyReader.java
    │       │   │       │       │   ├── [       2675]  DependencyTreeTransformer.java
    │       │   │       │       │   ├── [        389]  DependencyTyper.java
    │       │   │       │       │   ├── [       9371]  DiskTreebank.java
    │       │   │       │       │   ├── [      84482]  EnglishGrammaticalRelations.java
    │       │   │       │       │   ├── [      71112]  EnglishGrammaticalStructure.java
    │       │   │       │       │   ├── [       1028]  FilteringTreeReader.java
    │       │   │       │       │   ├── [      20072]  GrammaticalRelation.java
    │       │   │       │       │   ├── [       3511]  GrammaticalStructureFactory.java
    │       │   │       │       │   ├── [        480]  GrammaticalStructureFromDependenciesFactory.java
    │       │   │       │       │   ├── [      67238]  GrammaticalStructure.java
    │       │   │       │       │   ├── [       1457]  HeadFinder.java
    │       │   │       │       │   ├── [       4096]  international
    │       │   │       │       │   │   ├── [       4096]  arabic
    │       │   │       │       │   │   │   ├── [       9482]  ArabicHeadFinder.java
    │       │   │       │       │   │   │   ├── [       6351]  ArabicTreebankLanguagePack.java
    │       │   │       │       │   │   │   ├── [       2354]  ArabicTreebankTokenizer.java
    │       │   │       │       │   │   │   ├── [       8545]  ArabicTreeNormalizer.java
    │       │   │       │       │   │   │   └── [       2862]  ArabicTreeReaderFactory.java
    │       │   │       │       │   │   ├── [       4096]  french
    │       │   │       │       │   │   │   ├── [       4580]  DybroFrenchHeadFinder.java
    │       │   │       │       │   │   │   ├── [       4481]  FrenchHeadFinder.java
    │       │   │       │       │   │   │   ├── [       3710]  FrenchTreebankLanguagePack.java
    │       │   │       │       │   │   │   ├── [       4560]  FrenchTreeNormalizer.java
    │       │   │       │       │   │   │   ├── [        878]  FrenchTreeReaderFactory.java
    │       │   │       │       │   │   │   └── [      11863]  FrenchTreeReader.java
    │       │   │       │       │   │   ├── [       4096]  hebrew
    │       │   │       │       │   │   │   ├── [       2174]  HebrewTreebankLanguagePack.java
    │       │   │       │       │   │   │   ├── [       1668]  HebrewTreeNormalizer.java
    │       │   │       │       │   │   │   └── [       1767]  HebrewTreeReaderFactory.java
    │       │   │       │       │   │   ├── [       4096]  negra
    │       │   │       │       │   │   │   ├── [       2759]  NegraLabel.java
    │       │   │       │       │   │   │   ├── [       6975]  NegraPennLanguagePack.java
    │       │   │       │       │   │   │   ├── [      15809]  NegraPennLexer.java
    │       │   │       │       │   │   │   ├── [        740]  NegraPennTokenizer.java
    │       │   │       │       │   │   │   ├── [       7022]  NegraPennTreeNormalizer.java
    │       │   │       │       │   │   │   ├── [       2383]  NegraPennTreeReaderFactory.java
    │       │   │       │       │   │   │   └── [       9590]  TigerHeadFinder.java
    │       │   │       │       │   │   └── [       4096]  pennchinese
    │       │   │       │       │   │       ├── [       4031]  BikelChineseHeadFinder.java
    │       │   │       │       │   │       ├── [       7264]  CharacterLevelTagExtender.java
    │       │   │       │       │   │       ├── [       2988]  ChineseCollinizer.java
    │       │   │       │       │   │       ├── [      13034]  ChineseEnglishWordMap.java
    │       │   │       │       │   │       ├── [       2218]  ChineseEscaper.java
    │       │   │       │       │   │       ├── [      43604]  ChineseGrammaticalRelations.java
    │       │   │       │       │   │       ├── [      11004]  ChineseGrammaticalStructure.java
    │       │   │       │       │   │       ├── [       6522]  ChineseHeadFinder.java
    │       │   │       │       │   │       ├── [       1369]  ChineseSemanticHeadFinder.java
    │       │   │       │       │   │       ├── [      10850]  ChineseTreebankLanguagePack.java
    │       │   │       │       │   │       ├── [      24351]  CHTBLexer.java
    │       │   │       │       │   │       ├── [       2250]  CHTBTokenizer.java
    │       │   │       │       │   │       ├── [       9489]  CTBErrorCorrectingTreeNormalizer.java
    │       │   │       │       │   │       ├── [       1181]  CTBTreeReaderFactory.java
    │       │   │       │       │   │       ├── [       1147]  FragDiscardingPennTreeReader.java
    │       │   │       │       │   │       ├── [     136077]  RadicalMap.java
    │       │   │       │       │   │       └── [       3474]  SunJurafskyChineseHeadFinder.java
    │       │   │       │       │   ├── [       5026]  LabeledConstituent.java
    │       │   │       │       │   ├── [       1518]  Labeled.java
    │       │   │       │       │   ├── [        606]  LabeledScoredConstituentFactory.java
    │       │   │       │       │   ├── [       4139]  LabeledScoredConstituent.java
    │       │   │       │       │   ├── [       2024]  LabeledScoredTreeFactory.java
    │       │   │       │       │   ├── [       5406]  LabeledScoredTreeNode.java
    │       │   │       │       │   ├── [       1563]  LabeledScoredTreeReaderFactory.java
    │       │   │       │       │   ├── [        519]  LeftHeadFinder.java
    │       │   │       │       │   ├── [      15295]  MemoryTreebank.java
    │       │   │       │       │   ├── [      10160]  ModCollinsHeadFinder.java
    │       │   │       │       │   ├── [       3127]  NamedDependency.java
    │       │   │       │       │   ├── [      23872]  NPTmpRetainingTreeNormalizer.java
    │       │   │       │       │   ├── [       5983]  PennTreebankLanguagePack.java
    │       │   │       │       │   ├── [       1946]  PennTreebankTokenizer.java
    │       │   │       │       │   ├── [       1651]  PennTreeReaderFactory.java
    │       │   │       │       │   ├── [       8586]  PennTreeReader.java
    │       │   │       │       │   ├── [       4255]  QPTreeTransformer.java
    │       │   │       │       │   ├── [      22360]  SemanticHeadFinder.java
    │       │   │       │       │   ├── [       4096]  semgraph
    │       │   │       │       │   │   ├── [       1485]  SemanticGraphCoreAnnotations.java
    │       │   │       │       │   │   ├── [       4613]  SemanticGraphEdge.java
    │       │   │       │       │   │   ├── [      16389]  SemanticGraphFactory.java
    │       │   │       │       │   │   ├── [       7969]  SemanticGraphFormatter.java
    │       │   │       │       │   │   └── [      65968]  SemanticGraph.java
    │       │   │       │       │   ├── [        588]  SimpleConstituentFactory.java
    │       │   │       │       │   ├── [       4423]  SimpleConstituent.java
    │       │   │       │       │   ├── [       1044]  SimpleTreeFactory.java
    │       │   │       │       │   ├── [       2821]  SimpleTree.java
    │       │   │       │       │   ├── [       2690]  Span.java
    │       │   │       │       │   ├── [       8367]  TransformingTreebank.java
    │       │   │       │       │   ├── [        218]  TreebankFactory.java
    │       │   │       │       │   ├── [      16445]  Treebank.java
    │       │   │       │       │   ├── [      13311]  TreebankLanguagePack.java
    │       │   │       │       │   ├── [       1322]  TreeCoreAnnotations.java
    │       │   │       │       │   ├── [       2036]  TreeFactory.java
    │       │   │       │       │   ├── [       5632]  TreeFunctions.java
    │       │   │       │       │   ├── [       4455]  TreeGraph.java
    │       │   │       │       │   ├── [       1392]  TreeGraphNodeFactory.java
    │       │   │       │       │   ├── [      26045]  TreeGraphNode.java
    │       │   │       │       │   ├── [      92297]  Tree.java
    │       │   │       │       │   ├── [        605]  TreeLeafLabelTransformer.java
    │       │   │       │       │   ├── [        707]  TreeLengthComparator.java
    │       │   │       │       │   ├── [       2907]  TreeNormalizer.java
    │       │   │       │       │   ├── [      38216]  TreePrint.java
    │       │   │       │       │   ├── [        506]  TreeReaderFactory.java
    │       │   │       │       │   ├── [        592]  TreeReader.java
    │       │   │       │       │   ├── [      21397]  Trees.java
    │       │   │       │       │   ├── [       2561]  TreeToBracketProcessor.java
    │       │   │       │       │   ├── [       1466]  TreeTokenizerFactory.java
    │       │   │       │       │   ├── [        928]  TreeTransformer.java
    │       │   │       │       │   ├── [        779]  TreeVisitor.java
    │       │   │       │       │   ├── [       4096]  tregex
    │       │   │       │       │   │   ├── [       6603]  CoordinationPattern.java
    │       │   │       │       │   │   ├── [      14956]  DescriptionPattern.java
    │       │   │       │       │   │   ├── [       2478]  Macros.java
    │       │   │       │       │   │   ├── [       6187]  ParseException.java
    │       │   │       │       │   │   ├── [      55097]  Relation.java
    │       │   │       │       │   │   ├── [      11704]  SimpleCharStream.java
    │       │   │       │       │   │   ├── [       4089]  Token.java
    │       │   │       │       │   │   ├── [       4432]  TokenMgrError.java
    │       │   │       │       │   │   ├── [       5625]  TregexMatcher.java
    │       │   │       │       │   │   ├── [        474]  TregexParseException.java
    │       │   │       │       │   │   ├── [       1122]  TregexParserConstants.java
    │       │   │       │       │   │   ├── [      19773]  TregexParser.java
    │       │   │       │       │   │   ├── [      18074]  TregexParserTokenManager.java
    │       │   │       │       │   │   ├── [       4750]  TregexPatternCompiler.java
    │       │   │       │       │   │   ├── [      37899]  TregexPattern.java
    │       │   │       │       │   │   ├── [       4096]  tsurgeon
    │       │   │       │       │   │   │   ├── [       1347]  AdjoinNode.java
    │       │   │       │       │   │   │   ├── [       1327]  AdjoinToFootNode.java
    │       │   │       │       │   │   │   ├── [        925]  AdjoinToHeadNode.java
    │       │   │       │       │   │   │   ├── [       6274]  AuxiliaryTree.java
    │       │   │       │       │   │   │   ├── [        806]  CoindexationGenerator.java
    │       │   │       │       │   │   │   ├── [        714]  CoindexNodes.java
    │       │   │       │       │   │   │   ├── [        893]  DeleteNode.java
    │       │   │       │       │   │   │   ├── [       1510]  ExciseNode.java
    │       │   │       │       │   │   │   ├── [        762]  FetchNode.java
    │       │   │       │       │   │   │   ├── [        573]  HoldTreeNode.java
    │       │   │       │       │   │   │   ├── [        980]  InsertNode.java
    │       │   │       │       │   │   │   ├── [       3281]  JJTTsurgeonParserState.java
    │       │   │       │       │   │   │   ├── [       1081]  MoveNode.java
    │       │   │       │       │   │   │   ├── [       1055]  Node.java
    │       │   │       │       │   │   │   ├── [       6196]  ParseException.java
    │       │   │       │       │   │   │   ├── [       1263]  PruneNode.java
    │       │   │       │       │   │   │   ├── [       5809]  RelabelNode.java
    │       │   │       │       │   │   │   ├── [        835]  ReplaceNode.java
    │       │   │       │       │   │   │   ├── [      11713]  SimpleCharStream.java
    │       │   │       │       │   │   │   ├── [       1826]  SimpleNode.java
    │       │   │       │       │   │   │   ├── [       4098]  Token.java
    │       │   │       │       │   │   │   ├── [       4441]  TokenMgrError.java
    │       │   │       │       │   │   │   ├── [       1678]  TreeLocation.java
    │       │   │       │       │   │   │   ├── [      24113]  Tsurgeon.java
    │       │   │       │       │   │   │   ├── [        489]  TsurgeonParseException.java
    │       │   │       │       │   │   │   ├── [       2067]  TsurgeonParserConstants.java
    │       │   │       │       │   │   │   ├── [      26985]  TsurgeonParser.java
    │       │   │       │       │   │   │   ├── [      29348]  TsurgeonParserTokenManager.java
    │       │   │       │       │   │   │   ├── [        759]  TsurgeonParserTreeConstants.java
    │       │   │       │       │   │   │   ├── [       2871]  TsurgeonPattern.java
    │       │   │       │       │   │   │   └── [        966]  TsurgeonPatternRoot.java
    │       │   │       │       │   │   └── [       1678]  VariableStrings.java
    │       │   │       │       │   ├── [       3539]  TypedDependency.java
    │       │   │       │       │   ├── [       4368]  UnnamedConcreteDependency.java
    │       │   │       │       │   ├── [       4851]  UnnamedDependency.java
    │       │   │       │       │   ├── [        877]  WordCatConstituent.java
    │       │   │       │       │   ├── [        864]  WordCatEqualityChecker.java
    │       │   │       │       │   ├── [        436]  WordCatEquivalenceClasser.java
    │       │   │       │       │   ├── [        359]  WordNetConnection.java
    │       │   │       │       │   └── [       1188]  WordStemmer.java
    │       │   │       │       └── [       4096]  util
    │       │   │       │           ├── [        458]  AbstractIterator.java
    │       │   │       │           ├── [      11668]  ArrayCoreMap.java
    │       │   │       │           ├── [       9016]  ArrayHeap.java
    │       │   │       │           ├── [        608]  ArrayIterable.java
    │       │   │       │           ├── [       5543]  ArrayMap.java
    │       │   │       │           ├── [       1466]  ArraySet.java
    │       │   │       │           ├── [      21075]  ArrayUtils.java
    │       │   │       │           ├── [       2299]  Beam.java
    │       │   │       │           ├── [      14070]  BinaryHeapPriorityQueue.java
    │       │   │       │           ├── [       1656]  ByteStreamGobbler.java
    │       │   │       │           ├── [       1555]  Characters.java
    │       │   │       │           ├── [       3675]  CollectionFactory.java
    │       │   │       │           ├── [      26084]  CollectionUtils.java
    │       │   │       │           ├── [      13433]  CollectionValuedMap.java
    │       │   │       │           ├── [       1939]  Comparators.java
    │       │   │       │           ├── [       1141]  ConcatenationIterator.java
    │       │   │       │           ├── [       4096]  concurrent
    │       │   │       │           │   └── [       4428]  SynchronizedInterner.java
    │       │   │       │           ├── [       2156]  ConcurrentHashSet.java
    │       │   │       │           ├── [       1282]  CoreMap.java
    │       │   │       │           ├── [       1173]  DataFilePaths.java
    │       │   │       │           ├── [       7328]  DeltaCollectionValuedMap.java
    │       │   │       │           ├── [       4643]  DeltaIndex.java
    │       │   │       │           ├── [       9172]  DeltaMap.java
    │       │   │       │           ├── [       4053]  EditDistance.java
    │       │   │       │           ├── [       1695]  ErasureUtils.java
    │       │   │       │           ├── [        362]  Factory.java
    │       │   │       │           ├── [       3359]  FilePathProcessor.java
    │       │   │       │           ├── [        627]  FileProcessor.java
    │       │   │       │           ├── [       1877]  FilteredIterator.java
    │       │   │       │           ├── [        516]  Filter.java
    │       │   │       │           ├── [       5563]  Filters.java
    │       │   │       │           ├── [       7919]  FixedPrioritiesPriorityQueue.java
    │       │   │       │           ├── [        811]  Function.java
    │       │   │       │           ├── [       5921]  FuzzyInterval.java
    │       │   │       │           ├── [       4765]  Generics.java
    │       │   │       │           ├── [       4198]  HashableCoreMap.java
    │       │   │       │           ├── [      13459]  HashIndex.java
    │       │   │       │           ├── [        458]  HasInterval.java
    │       │   │       │           ├── [       2203]  Heap.java
    │       │   │       │           ├── [       7891]  IdentityHashSet.java
    │       │   │       │           ├── [       4137]  Index.java
    │       │   │       │           ├── [       3165]  Interner.java
    │       │   │       │           ├── [      26506]  Interval.java
    │       │   │       │           ├── [       7844]  IntervalTree.java
    │       │   │       │           ├── [        767]  IntPair.java
    │       │   │       │           ├── [        734]  IntQuadruple.java
    │       │   │       │           ├── [        634]  IntTriple.java
    │       │   │       │           ├── [       3501]  IntTuple.java
    │       │   │       │           ├── [        630]  IntUni.java
    │       │   │       │           ├── [       1049]  IterableIterator.java
    │       │   │       │           ├── [       4096]  logging
    │       │   │       │           │   ├── [        547]  Color.java
    │       │   │       │           │   ├── [       2176]  LogRecordHandler.java
    │       │   │       │           │   ├── [      13359]  OutputHandler.java
    │       │   │       │           │   ├── [       1332]  PrettyLoggable.java
    │       │   │       │           │   ├── [       8986]  PrettyLogger.java
    │       │   │       │           │   ├── [      16348]  RedwoodConfiguration.java
    │       │   │       │           │   ├── [      58214]  Redwood.java
    │       │   │       │           │   ├── [       4262]  RedwoodPrintStream.java
    │       │   │       │           │   ├── [       9079]  RepeatedRecordHandler.java
    │       │   │       │           │   ├── [        436]  Style.java
    │       │   │       │           │   └── [       3284]  VisibilityHandler.java
    │       │   │       │           ├── [        339]  LowercaseFunction.java
    │       │   │       │           ├── [       9089]  MapFactory.java
    │       │   │       │           ├── [       5611]  Maps.java
    │       │   │       │           ├── [       8162]  MemoryMonitor.java
    │       │   │       │           ├── [      20340]  MetaClass.java
    │       │   │       │           ├── [       2725]  MutableDouble.java
    │       │   │       │           ├── [       2787]  MutableInteger.java
    │       │   │       │           ├── [       2109]  PaddedList.java
    │       │   │       │           ├── [       7155]  Pair.java
    │       │   │       │           ├── [       4581]  PriorityQueue.java
    │       │   │       │           ├── [       6841]  PropertiesUtils.java
    │       │   │       │           ├── [       1533]  ReflectionLoading.java
    │       │   │       │           ├── [       1916]  ScoredComparator.java
    │       │   │       │           ├── [        510]  Scored.java
    │       │   │       │           ├── [        673]  ScoredObject.java
    │       │   │       │           ├── [       3127]  Sets.java
    │       │   │       │           ├── [       1005]  StreamGobbler.java
    │       │   │       │           ├── [       4411]  StringParsingTask.java
    │       │   │       │           ├── [      57738]  StringUtils.java
    │       │   │       │           ├── [      10019]  SystemUtils.java
    │       │   │       │           ├── [       9324]  Timing.java
    │       │   │       │           ├── [       2720]  Triple.java
    │       │   │       │           ├── [       2316]  TypesafeMap.java
    │       │   │       │           └── [      32263]  XMLUtils.java
    │       │   │       └── [       4096]  umbc
    │       │   │           ├── [       4096]  dbpedia
    │       │   │           │   ├── [       4096]  model
    │       │   │           │   │   ├── [        934]  BestCombinationElement.java
    │       │   │           │   │   ├── [        812]  ChoiceElement.java
    │       │   │           │   │   ├── [        609]  CoElement.java
    │       │   │           │   │   ├── [       1120]  FloatElement.java
    │       │   │           │   │   ├── [        904]  GeneralizingClassElement.java
    │       │   │           │   │   ├── [       1075]  ImprovedRecallResult.java
    │       │   │           │   │   ├── [       4854]  LinkedGraphModel.java
    │       │   │           │   │   ├── [       2232]  Link.java
    │       │   │           │   │   ├── [      12177]  LSA_Model.java
    │       │   │           │   │   ├── [       1696]  Node.java
    │       │   │           │   │   ├── [        612]  QueueElement.java
    │       │   │           │   │   ├── [        578]  RelationDimensionElement.java
    │       │   │           │   │   ├── [      25496]  SimilarityArrayModel.java
    │       │   │           │   │   ├── [      16609]  SimilarityModel.java
    │       │   │           │   │   ├── [       4613]  SimilarityTreeMapModel.java
    │       │   │           │   │   ├── [        942]  SimilarPropertyElement.java
    │       │   │           │   │   └── [       1212]  STS_Example.java
    │       │   │           │   └── [       4096]  util
    │       │   │           │       ├── [      39970]  ComplexPredicate.java
    │       │   │           │       ├── [        425]  Contradiction.java
    │       │   │           │       ├── [       8868]  DependencyCheck.java
    │       │   │           │       ├── [       2759]  FlexibleDateParser.java
    │       │   │           │       ├── [       4567]  LexicalProcess.java
    │       │   │           │       ├── [        343]  MappingEntry.java
    │       │   │           │       ├── [        934]  OrderedWord.java
    │       │   │           │       ├── [        448]  StringMarkerElement.java
    │       │   │           │       └── [       5994]  Test.java
    │       │   │           ├── [       4096]  nlp
    │       │   │           │   └── [       4096]  tool
    │       │   │           │       ├── [       6541]  NumberConverter.java
    │       │   │           │       ├── [       1608]  NumberConvertTest.java
    │       │   │           │       ├── [        193]  NumberException.java
    │       │   │           │       └── [       1477]  StringSimilarity.java
    │       │   │           ├── [       4096]  similarity
    │       │   │           │   └── [       4096]  dictionary
    │       │   │           │       └── [      20489]  StanfordTermTokenizer.java
    │       │   │           └── [       4096]  web
    │       │   │               ├── [        862]  Configure.java
    │       │   │               └── [       7207]  StsServlet.java
    │       │   └── [        463]  web.xml
    │       └── [       4096]  work
    │           ├── [         81]  SESSIONS.ser
    │           └── [         44]  tldCache.ser
    ├── [  987567458]  umbc_sts.tar.gz
    └── [     312996]  xom.jar

    163 directories, 2937 files
