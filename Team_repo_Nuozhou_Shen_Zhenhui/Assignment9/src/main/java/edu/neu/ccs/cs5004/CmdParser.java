package edu.neu.ccs.cs5004;

import java.util.Objects;

/**
 * This class represents a command line parser.
 */
public class CmdParser {

  /**
   * The result returned by the parser.
   */
  protected CmdLineResult result;

  /**
   * The main method of the parser. Parse a command given a set of options.
   *
   * @param args the command
   * @param options the options
   * @return a result contains the options and correspondent arguments
   */
  public CmdLineResult parse(String[] args, Options options) {
    result = new CmdLineResult();
    Option optionNeedArg = null;

    for (int i = 0; i < args.length; i++) {
      String token = args[i];
      if (token.startsWith("--")) {  //is an option
        if (optionNeedArg != null) {  //missing argument
          System.out.println("Error! No Argument Found!");
          System.out.println(optionNeedArg.getOptName()
              + " " + optionNeedArg.getDescription());
          throw new MissingArgumentException();
        }
        if (!options.hasOptions(token)) {
          System.out.println("Error! Unrecognized Option!");
          throw new UnrecognizedOptionException();
        } else {
          Option opt = options.getOptionsMap().get(token);
          if (opt.isRequiredArg()) {
            optionNeedArg = opt;
          }
          result.addOption(opt);
        }
      } else {  //is an argument
        if (optionNeedArg == null) {
          System.out.println("Error! Unrecognized Option!");
          throw new UnrecognizedOptionException();
        }
        result.getOptions().get(optionNeedArg.getOptName()).setArgs(token);
        optionNeedArg = null;
      }
    }

    result.checkValidity();
    return result;
  }

  @Override
  public String toString() {
    return "This is a command line parser.";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    CmdParser cmdParser = (CmdParser) obj;
    return Objects.equals(result, cmdParser.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }
}


